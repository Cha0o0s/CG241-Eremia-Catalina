import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static void ReadFile(String filename, points[] points,points m) {
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                m.setX(Integer.parseInt(parts[0]));  // Set x of m
                m.setY(Integer.parseInt(parts[1]));  // Set y of m
            }
            int n = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                points[n] = new points(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])); // Set Ai(x,y)
                n++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    static int q(points p){
        //check witch quadrant the point is in
        if(p.getX()>0 && p.getY()>=0) return 1;
        if(p.getX()<=0 && p.getY()>0) return 2;
        if(p.getX()<0 && p.getY()<=0) return 3;
        if(p.getX()>=0 && p.getY()<0) return 4;
        return 0;
    }
    static int delta(points p1, points p2, points p3){
        //delta of 3 points
        return p1.getX()*(p2.getY()-p3.getY())+p2.getX()*(p3.getY()-p1.getY())+p3.getX()*(p1.getY()-p2.getY());
    }
    void sort(points[] point,int n){
        //sort requirements P is after Q if q(P)>q(Q) or q(P)=q(Q) and delta(P,O,Q)>=0
        points O=new points(0,0);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++) {
                if (q(point[i]) > q(point[j]) || (q(point[i]) == q(point[j]) && delta(point[i], O, point[j]) >= 0)) {
                    points aux = new points(point[i].getX(), point[i].getY());//aux=p[i]
                    point[i].setX(point[j].getX());
                    point[i].setY(point[j].getY());//p[i]=p[i+1]
                    point[j].setX(aux.getX());
                    point[j].setY(aux.getY());//p[i+1]=aux
                }
            }
        }
    }
    static int binarySearch(points[] arr, points x){
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid].getX() < x.getX() && arr[mid].getY() < x.getY()  &&  arr[mid+1].getX() > x.getX() && arr[mid+1].getY() > x.getY())
                return mid;
            if (arr[mid].getX() < x.getX() && arr[mid].getY() < x.getY())
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        points[] A=new points[100];
        points O=new points(0,0);
        points m=new points(0,0);
        System.out.println("PB: Find M with respect to the polygon formed by the points");
        ReadFile(System.getProperty("user.dir") + "/src/input",A,m);
        System.out.println("Point M: "+m.getX()+", "+m.getY());
        int n = 0;
        while (A[n] != null && n < A.length) {
            System.out.println("Point " + (n + 1) + ": " + A[n].getX() + ", " + A[n].getY());
            n++;
        }
        //get G such that it is the new origin of axis with respect to polygon
        points G = new points(A[0].getX()+A[1].getX()+A[2].getY()/3,A[0].getY()+A[1].getY()+A[2].getX()/3);
        System.out.println("Point G: "+G.getX()+", "+G.getY());
        //translate the points in Ai such that G is the origin
        points[] B = new points[100];
        for (int i = 0; i < n; i++) {
            B[i] = new points(A[i].getX() - G.getX(), A[i].getY() - G.getY());
        }
        //sort the points in B (new Ai sorted around the x-axis in negative trig way)
        Main main=new Main();
        main.sort(B,n);
        System.out.println("Sorted B:");
        for(int i=0;i<n;i++){
            System.out.println( B[i].getX()+" "+ B[i].getY());
        }
        points m1=new points(m.getX()-G.getX(),m.getY()-G.getY());
        if(m1.getX()==0&&m1.getY()==0)//M is the origin
            System.out.println("M is in the Interior of the polygon");
        else//B1 is after M` or M` is after Bn -> special wedge
        if((q(B[0]) > q(m1) || (q(B[0]) == q(m1) && delta(B[0], O, m1) >= 0))||(q(m1) > q(B[n-1]) || (q(m1) == q(B[n-1]) && delta(m1, O, B[n-1]) >= 0))) {// M is on the line
            System.out.println("M is in the Special Wedge of the polygon");//last wedge
            if (delta(m1, B[n - 1], B[0]) > 0) System.out.println("M is in the Interior of the polygon");
            else if (delta(m1, B[n - 1], B[0]) < 0) System.out.println("M is in the Exterior of the polygon");
            else if (delta(m1, B[n - 1], B[0]) == 0) System.out.println("M is on the Border of the polygon");
        }else {
                int k=binarySearch(B,m1);//we find M in the wedge(k) <=> M` is after Bk and Bk+1 is after M`(M` is M translated in G,M`=m1)
                if(delta(m1,B[k],B[k+1])>0)System.out.println("M is in the Interior of the polygon");
                else
                    if(delta(m1,B[k],B[k+1])<0)System.out.println("M is in the Exterior of the polygon");
                    else
                        if(delta(m1,B[k],B[k+1])==0)System.out.println("M is on the Border of the polygon");
            }
    }
}