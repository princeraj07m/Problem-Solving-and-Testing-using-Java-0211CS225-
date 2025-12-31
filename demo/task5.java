package demo;
// Task 5. Given an array of integers and a positive integer K, write a program to find:The Kth smallest element 

import java.util.Arrays;
public class task5 {
    public static void main(String[] args) {
        int []arr1 ={1,4,6,3,8,7,9,2,5};
        int lrank = 5;

        Arrays.sort(arr1);
        System.out.println(arr1[lrank-1]);
        
    }
}
