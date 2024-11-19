import java.util.Arrays;
import java.util.*;
public class Main {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }

        }
        return arr;
    }
    public static int intersection(int[] arr,int[] arr1){
        int i=0;
        int j=0;
        while(i<arr.length && j<arr1.length){//Explain complexity
            if(arr[i]==arr1[j])
                return 1;
            else if(arr[i]<arr1[j])
                i++;
            else
                j++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] A = {4,7,2,1};
        int[] B={5,8,10,2};
        int[] C={6,9,11,3};
        int[] B1=sort(B);
        for(int i=0;i<B1.length;i++){
            B1[i]=2*B1[i];
            System.out.printf(B1[i]+" ");
        }
        System.out.println();
        int[] C1=sort(C);
        int[] D = new int[4];
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<C1.length;j++) {
                D[j] = A[i] + C1[j];
            }
        }
        int intersectionValue = intersection(D, B1);
        if (intersectionValue==1)
            System.out.println("value found");
        else
            System.out.print("not found");

    }
}