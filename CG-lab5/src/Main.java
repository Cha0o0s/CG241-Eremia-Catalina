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
    static int delta(points a, points b, points c) {
        return a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY());
    }
    static int localisation(points[] setA,points m,int n){
        int c=0;
        points a=new points(0,0);
        points b=new points(0,0);
        for(int i=0;i<n-2;i++){
            if(setA[i].getY()==setA[i+1].getY()){
                if(m.getY()==setA[i].getY()&&(m.getX()-setA[i].getX())*(m.getX()-setA[i+1].getX())<=0){//yM=yA[i] and xM is between xA[i] and xA[i+1]
                    // M is on the line A[i] A[i+1]
                    return 10;
                }
                else{
                    if(setA[i].getY()<setA[i+1].getY()){
                        a.setX(setA[i].getX());
                        a.setY(setA[i].getY());
                        b.setX(setA[i+1].getX());
                        b.setY(setA[i+1].getY());
                    }
                    else{
                        b.setX(setA[i].getX());
                        b.setY(setA[i].getY());
                        a.setX(setA[i+1].getX());
                        a.setY(setA[i+1].getY());
                    }
                    if(delta(m,a,b)==0&&(m.getY()-a.getY())*(m.getY()-b.getY())<=0)//delta=0 yM is between yA and yB
                        return 10;//on the line AB
                    else if(delta(m,a,b)>0&&(m.getY()-a.getY())*(m.getY()-b.getY())<0)//delta>0 yM is between yA and yB
                        c++;//M is going through the line
                    else if(delta(m,a,b)>0 && m.getY()==b.getY())//delta>0 yM=yB
                        c++;//M is going through point
                }
            }
        }
        if(c%2==0)
            return 9;//outside the polygon
        else
            return 8;//inside the polygon
    }
    public static void main(String[] args) {
        points[] set=new points[100];
        points m=new points(0,0);
        ReadFile(System.getProperty("user.dir") + "/src/input",set,m);
        int n = 0;
        System.out.println("M is at (" + m.getX() + "," + m.getY() + ")");
        System.out.println("The points of the polygon are:");
        while (n < set.length && set[n] != null) {
            System.out.println("(" + set[n].getX() + "," + set[n].getY() + ")");
            n++;
        }
        int c=localisation(set,m,n);
        if(c==10)
            System.out.println("M is on the line");
        else if(c==9)
            System.out.println("M is outside the polygon");
        else
            if(c==8)
                System.out.println("M is inside the polygon");
    }
}