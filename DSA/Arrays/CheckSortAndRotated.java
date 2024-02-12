// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
// There may be duplicates in the original array.

// Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

public class CheckSortAndRotated {
    public boolean check(int[] nums) {
        boolean status = true;
        for(int i = 0; i < nums.length; i++) {
            if(i != nums.length-1 && status && nums[i] < nums[i+1]) {
                continue;
            } else if (i != nums.length-1 && status && nums[i] > nums[i+1]) {
                status = false;
            } else if (!status) {
                if (nums[i] > nums[0]) {
                    return false;
                } else if (i != nums.length-1 && nums[i] > nums[i+1]) {
                    return false;
                }
            } else if (!status){
                return false;
            } else {
                continue;
            }

        }
        return true;
    }
}