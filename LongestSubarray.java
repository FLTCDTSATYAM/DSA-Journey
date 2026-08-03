public class LongestSubarray{
    public static int longestSubArray(int arr[]){
        int n = arr.length;
        int maxCount = Integer.MIN_VALUE;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int count = 0;
                int Sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i-1];
                if(Sum == 0){
                    count = j - (i-1);
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int arr[] = {2, 10, 4};
        System.out.println(longestSubArray(arr));
    }
}