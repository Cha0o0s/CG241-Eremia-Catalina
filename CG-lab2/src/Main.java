import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*Pb: Let us consider a set of points A={Ai in R,i<=n,i>=1}.
    Apply the "string" procedure defined above.*/

public class Main {
    static void ReadFile(String filename, point[] points) {
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            int n = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                points[n] = new point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                n++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }static void ReadFile(String filename, point[] points) {
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            int n = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");
                points[n] = new point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                n++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    static int landa(int x, int y){
        if(x>0 && y>=0)return 1;
        if(x==0 && y>0)return 2;
        if(x<0 && y<=0)return 3;
        if(x>=0 && y<0)return 4;
        return 0;
    }
    static int det(int xa,int ya,int xb,int yb){
        return xa*yb-xb*ya;
    }
    public static void main(String[] args) {
        point[] A = new point[100];

        ReadFile(System.getProperty("user.dir") + "/src/Input", A);

        int n = 0;
        while (A[n] != null && n < A.length) {
            System.out.println("Point " + (n + 1) + ": " + A[n].getX() + ", " + A[n].getY());
            n++;
        }

        Comparator<point> pointComparator = new Comparator<point>() {
            @Override
            public int compare(point p1, point p2) {
                int landa1 = landa(p1.getX(), p1.getY());
                int landa2 = landa(p2.getX(), p2.getY());

                if (landa1 != landa2) {
                    return Integer.compare(landa1, landa2);
                }
                //if same quadrant
                int detValue = det(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                return Integer.compare(detValue, 0);
            }
        };

        Arrays.sort(A, 0, n, pointComparator);

        System.out.println("\nSorted Points:");
        for (int i = 0; i < n; i++) {
            System.out.println("Point " + (i + 1) + ": " + A[i].getX() + ", " + A[i].getY());
        }
    }
}
