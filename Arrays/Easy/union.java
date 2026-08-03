// Q) Return Union of two sorted arrays

import java.util.*;
public class union{
    // Brute force approach - O(m+n)log(m+n)
    public static ArrayList<Integer> solution(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < m; i++){
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < n; i++){
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(key);
        }
        return list;
    }

    // using treeSet - O(m+n)log(m+n)
    public static ArrayList<Integer> unionSet(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;

        TreeSet<Integer> map = new TreeSet<>();

        for(int i = 0; i < m; i++){
            map.add(arr1[i]);
        }
        for(int i = 0; i < n; i++){
            map.add(arr2[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int value : map){
            list.add(value);
        }
        return list;
    }
    public static void main(String args[]){
        int arr1[] = {3,4,6,7,9,9};
        int arr2[] = {1,5,7,8,8};
        System.out.println(unionSet(arr1,arr2));
    }
}