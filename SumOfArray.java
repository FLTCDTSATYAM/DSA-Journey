import java.util.Arrays;

public class SumOfArray {
    public static int GCD(int maxElement, int arrElement){
        int rem = -1;
        while(rem != 0){
            rem = maxElement % arrElement;
            maxElement = arrElement;
            arrElement = rem;
            if(rem == 0){
                return maxElement;
            }
        }
        return rem;
    }
    public static int sumOfArray(int arr[]){
        int maxElement = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxElement = Math.max(arr[i], maxElement);
            arr[i] = GCD(maxElement, arr[i]);
        }
        Arrays.sort(arr);
        int sum = 0;
        int newArr[] = new int[arr.length/2];
        for(int i = 0; i < newArr.length; i++){
            newArr[i] = GCD(arr[arr.length-1-i], arr[i]);
            sum += newArr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter size of array: ");
        // int n = sc.nextInt();
        int arr[] = {12,15,3,10};
        System.out.println(sumOfArray(arr));
    }
}

