import java.util.*;

public class rotated_array{
    // Brute Force approach
    public static int[] rotatedArrayBrute(int arr[], int k){
        int n = arr.length;
        if(n <= 1){
            return arr;
        }
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[(i+k) % n] = arr[i];
        }
        return nums;
    }
    public static int[] optimalApproach(int arr[], int k){
        int n = arr.length;
        if(n <= 1){
            return arr;
        }
        int r = 0;
        while(r < n-k){
            int firstElement = arr[0];
            for(int i = 1; i < n; i++){
                arr[i-1] = arr[i];
            }
            arr[n-1] = firstElement;
        }
        return arr;
    }
    public static int[] reverse(int arr[], int k, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    public static int[] expectedApproach(int arr[], int k){
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        if(n <= 1){
            return arr;
        }
        reverse(arr,k,0,n-1);
        reverse(arr,k,0,k-1);
        return reverse(arr,k,k,n-1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        k = k % arr.length;
        System.out.println(Arrays.toString(expectedApproach(arr,k)));
    }
}