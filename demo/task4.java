package demo;
// Task 4. Find the maximum element in an array of n integers 
public class task4 {
    public static void main(String args[]){
        int []arr1 = {1,2,3,14,5,6,7,8,9};

        int max = arr1[0];

        for(int i = 1;i<arr1.length;i++){
            if(arr1[i]>max){
                max = arr1[i];
            }
        }
        System.out.println("maximum element is : " + max);
    }
}
