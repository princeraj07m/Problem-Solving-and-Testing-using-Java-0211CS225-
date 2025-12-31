package demo;
// Task 3. Search for a given element in a sorted array using Binary Search. 
public class task3 {
    public static void main(String args[]){
        int []arr = {1,2,3,4,5,6,7,8,9};

        int target = 8;

        int low = 0;
        int high = arr.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                System.out.println(mid);
                return;
            }else if(arr[mid]<target){
                low = mid+1;
            }else if(arr[mid]>target){
                high = mid-1;
            }
        }
        System.out.println("-1");

    }
}
