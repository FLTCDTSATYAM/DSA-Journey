package Arrays.Easy;

import java.util.*;

public class second_Largest_Element {
    // Brute force approach
    public static int SLE(int arr[], int n){
        if(n == 0 || n == 1){
            return -1;
        }
        //1. find largest
        int idx = 0;
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            largest = Math.max(largest, arr[i]);
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == largest){
                idx = i;
            }
        }
        // 2. swap largest with first element
        int temp = arr[idx];
        arr[idx] = arr[0];
        arr[0] = temp;
        // 3. run loop to find largest from remaining
        int secLargest = -1;
        for(int j = 1; j < n; j++){
            secLargest = Math.max(secLargest, arr[j]);
        }
        return secLargest;
    }
    // Optimized solution
    public static int SLE2(int arr[], int n){
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] > largest){
                secLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secLargest || arr[i] != largest){
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Second largest element in an array is: "+SLE2(arr, n));
    }
}
