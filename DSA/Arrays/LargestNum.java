import java.util.* ;
import java.io.*; 

public class LargestNum {

    static int largestElement(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;
        for(int num : arr) {
            if(num > largest) {
                largest = num;
            }
        }
        return largest;

    }
}