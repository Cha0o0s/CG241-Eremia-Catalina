import java.io.*;

class BinarySearch {

    int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;
    }
    int binarySearch_between(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <x  &&  arr[mid+1]  >x)
                return mid;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 20;
        if(x<arr[0])
            System.out.println("x is before "+arr[0]);
        else if(x>arr[n-1])
            System.out.println("x is after an "+arr[n-1]);
        else{
        int result = ob.binarySearch(arr, x);
            if (result != -1)
                System.out.println("x is "+arr[result]);
            else {
                int result1 = ob.binarySearch_between(arr, x);
                if(result1!=-1)
                    System.out.println("x is between "+arr[result1]+" and "+arr[result1+1]);
            }
        }
    }
}
