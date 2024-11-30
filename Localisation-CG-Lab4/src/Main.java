public class Main {
    static int determinant(point a, point b, point c) {
        return a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY());
    }
    public static void main(String[] args) {
        //for delta<0
        point a=new point(2,0);
        point b=new point(7,4);
        point c=new point(10,1);
        //for delta>0
        /*
        point a=new point(2,3);
        point b=new point(0,1);
        point c=new point(5,2);
        */
        point m=new point(2,0);
        System.out.println("det ABC:"+determinant(a,b,c));
        if(determinant(a,b,c)==0)
            System.out.println("ABC is not a triangle");
        else{
            int d1=determinant(m,a,b);
            int d2=determinant(m,b,c);
            int d3=determinant(m,c,a); //d3 from reg* table
            System.out.println("d1:"+d1 +"\nd2:"+d2+ "\nd3:"+d3);
            if(determinant(a,b,c)>0){
                if(d1>0 && d2>0 && d3>0)
                    System.out.println("M is in region 1");
                else
                if(d1==0 && d2>0 && d3==0)
                    System.out.println("M is in region 2");
                else
                if(d1==0 && d2==0 && d3>0)
                    System.out.println("M is in region 3");
                else
                if(d1>0 && d2==0 && d3==0)
                    System.out.println("M is in region 4");
                else
                if(d1==0 && d2>0 && d3>0)
                    System.out.println("M is in region 5");
                else
                if(d1>0 && d2==0 && d3>0)
                    System.out.println("M is in region 6");
                else
                if(d1>0 && d2>0 && d3==0)
                    System.out.println("M is in region 7");
                else
                if(d1<0 && d2>0 && d3>0)
                    System.out.println("M is in region 8");
                else
                if(d1>0 && d2<0 && d3>0)
                    System.out.println("M is in region 9");
                else
                if(d1>0 && d2>0 && d3<0)
                    System.out.println("M is in region 10");
                else
                if(d1<0 && d2>0 && d3<0)
                    System.out.println("M is in region 11");
                else
                if(d1<0 && d2<0 && d3>0)
                    System.out.println("M is in region 12");
                else
                if(d1>0 && d2<0 && d3<0)
                    System.out.println("M is in region 13");
                else
                if(d1<0 && d2>0 && d3==0)
                    System.out.println("M is in region 14");
                else
                if(d1<0 && d2==0 && d3>0)
                    System.out.println("M is in region 15");
                else
                if(d1==0 && d2<0 && d3>0)
                    System.out.println("M is in region 16");
                else
                if(d1>0 && d2<0 && d3==0)
                    System.out.println("M is in region 17");
                else
                if(d1>0 && d2==0 && d3<0)
                    System.out.println("M is in region 18");
                else
                if(d1==0 && d2>0 && d3<0)
                    System.out.println("M is in region 19");
            }
            else if(determinant(a,b,c)<0){
                if(d1<0 && d2<0 && d3<0)
                    System.out.println("M is in region 1");
                else
                if(d1==0 && d2<0 && d3==0)
                    System.out.println("M is in region 2");
                else
                if(d1==0 && d2==0 && d3<0)
                    System.out.println("M is in region 3");
                else
                if(d1<0 && d2==0 && d3==0)
                    System.out.println("M is in region 4");
                else
                if(d1==0 && d2<0 && d3<0)
                    System.out.println("M is in region 5");
                else
                if(d1<0 && d2==0 && d3<0)
                    System.out.println("M is in region 6");
                else
                if(d1<0 && d2<0 && d3==0)
                    System.out.println("M is in region 7");
                else
                if(d1>0 && d2<0 && d3<0)
                    System.out.println("M is in region 8");
                else
                if(d1<0 && d2>0 && d3<0)
                    System.out.println("M is in region 9");
                else
                if(d1<0 && d2<0 && d3>0)
                    System.out.println("M is in region 10");
                else
                if(d1>0 && d2<0 && d3>0)
                    System.out.println("M is in region 11");
                else
                if(d1>0 && d2>0 && d3<0)
                    System.out.println("M is in region 12");
                else
                if(d1<0 && d2>0 && d3>0)
                    System.out.println("M is in region 13");
                else
                if(d1>0 && d2<0 && d3==0)
                    System.out.println("M is in region 14");
                else
                if(d1>0 && d2==0 && d3<0)
                    System.out.println("M is in region 15");
                else
                if(d1==0 && d2>0 && d3<0)
                    System.out.println("M is in region 16");
                else
                if(d1<0 && d2>0 && d3==0)
                    System.out.println("M is in region 17");
                else
                if(d1<0 && d2==0 && d3>0)
                    System.out.println("M is in region 18");
                else
                if(d1==0 && d2<0 && d3>0)
                    System.out.println("M is in region 19");
            }
        }
    }
}
