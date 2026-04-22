package Arrays.Easy;
import java.util.*;
public class chk_sorted {
    // Brute Force
    public boolean check(int[] nums, int n) {
        if(n == 0 || n == 1){
            return true;
        }
        int nums2[] = new int[nums.length];
        for(int r = n - 1; r >= 0; r--){
            boolean sorted = false;
            for(int j = 0; j < n; j++){
                nums2[j] = nums[(j + r) % n];
            }
            for(int i = 0; i < n-1; i++){
                if(nums2[i] <= nums2[i+1]){
                    sorted = true;
                }else{
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                return true;
            }
        }
        return false;
    }
    // Optimal approach
    public static boolean chkSortedOptimal(int arr[], int n){
        if(n == 0 || n == 1){
            return true;
        }
        int count = 0;
        for(int i = 0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                count++;
            }
        }
        if((count == 1 && arr[0] > arr[n-1]) || count == 0){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array is Sorted: " + chkSortedOptimal(arr,n));
    }
}
