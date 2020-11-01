import java.util.Arrays;

/**
 * Problem: Given a positive integer n, return
 * the next greatest integer that can be made
 * from its digits. If such a number does not
 * exit, return -1.
 *
 * Author: AnxietyMedicine (GitHub)
/*
public class NextGreatestNumber {
    // Utility function to swap two elements of an int array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Converts an int to an array of its digits
    public static int[] convertIntToDigitArray(int num) {
        return Integer.toString(num).chars().map(a -> a - '0').toArray();
    }

    // Converts an array of digits into an int
    public static int convertDigitArrayToInt(int[] arr) {
        int n = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            n += arr[i] * Math.pow(10, arr.length - i - 1);
        }

        return n;
    }

    public static int findNextGreatest(int n) {
        int[] arr = convertIntToDigitArray(n);
        int i;

        // Traverse from the rightmost digit
        for (i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) break;
        }

        // If all elements are in descending order, a next greatest is not possible
        // If there is only one digit, a next greatest is also not possible
        if (i == 0 || arr.length == 0) return -1;

        int x = arr[i - 1];
        int min = i;

        // Find the smallest digit on the right side of the (i-1)'th digit
        // that is greater than arr[i - 1]
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > x && arr[j] < arr[min]) min = j;
        }

        // Swap the above found smallest digit with arr[i - 1]
        swap(arr, i - 1, min);

        // Sort the digits after index "i - 1" in ascending order
        Arrays.sort(arr, i, arr.length);

        // Return the array as an int
        return convertDigitArrayToInt(arr);
    }

    public static void main(String[] args) {
        int n = 534976; // Output should be 536479
        int result = findNextGreatest(n);
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + result);
    }
}
