public class SecondLargestAndSmallestNum {
    public static int[] getSecondOrderElements(int n, int []a) {
        int largestNum = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallNum = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for(int num : a) {
            if(num > largestNum) {
                secondLargest = largestNum;
                largestNum = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }

            if(num < smallNum) {
                secondSmall = smallNum;
                smallNum = num;
            } else if (num < secondSmall) {
                secondSmall = num;
            }
        }
        return new int[] {secondLargest, secondSmall};
    }
}