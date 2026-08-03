import java.util.*;

public class missingNumber{
    public static int missingOneNum(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int curr = arr[i];
            int count = 0;
            for(int j = 0; j < n; j++){
                if(curr == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                return arr[i];
            }
        }
        return -1;
    }
    public static int betterApproach(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        System.out.println(missingOneNum(arr));
    }
}