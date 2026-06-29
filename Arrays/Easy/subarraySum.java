public class subarraySum{
    public static int longestSubArraySum(int arr[], int k){ //T.C = O(n^3)
        int n = arr.length;
        int maxCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int currSum = 0;
                int count = 0;
                for(int m = i; m <= j; m++){
                    currSum += arr[m];
                    count++;
                }
                if(currSum == k){
                    maxCount = Math.max(count,maxCount);
                }
            }
        }
        return maxCount;
    }
    public static int betterApproach(int arr[], int k){
        int n = arr.length;
        int maxCount = 0;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int i = 0; i < n; i++){
            int currSum = 0;
            for(int j = i; j < n; j++){
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(currSum == k){
                    int count = j-i+1;
                    maxCount = Math.max(count, maxCount);
                }
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int arr[] = {10,5,2,7,1,9};
        int k = 15;
        System.out.println(longestSubArraySum(arr,k));
    }
}