package com.ach.min_swaps;

import javafx.util.Pair;

import java.io.IOException;

/**
 * Created by antoniochavez on 15/09/2018.
 * <p>
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps
 * required to sort the array in ascending order.
 * For example, given the array  we perform the following steps:
 * i   arr                         swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 */
public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        final int size = arr.length;
        // Let's resolve this by recursion:
        //Base case if the array is size 2 (Even number of elements) or size 3 (Odd number of elements)
        if (size == 2 || size == 3) {
            return baseCaseSwaps(arr);
        }

        return 0;
    }

    public static int baseCaseSwaps(int[] arr) {

        final int size = arr.length;

        // - Array of two items: Even number of elements:
        if (size == 2) {
            if (arr[0] < arr[1]) {
                //   * If items are ordered -> 0 Swaps
                return 0;
            } else {
                //   * If items are unordered -> 1 Swap
                return 1;
            }
        }

        // Array of three items: Odd number of elements:
        if (size == 3) {
            MinMaxInfo minMax = getMinAndMaxInfo(arr);
            Integer minValueIndex = minMax.getMinInfo().getKey();
            Integer maxValueIndex = minMax.getMaxInfo().getKey();
            if (arr[0] < arr[1] && arr[1] < arr[2]) {
                // * If items are ordered -> 0 Swaps
                return 0;
            } else if (minValueIndex != 0 && maxValueIndex != 2) {
                // * If min is NOT first AND max is NO last -> 2 Swaps: i.e [2,3,1] => [1,3,2] => [1,2,3];
                //                                                        [3,1,2] => [1,3,2] => [1,2,3]
                return 2;
            } else {
                // Else -> 1 Swaps: i.e [1,3,2] => [1,2,3]; [2,1,3] => [1,2,3]
                return 1;
            }

        }
        throw new IllegalArgumentException("Invalid array for base case: Array size is different from 2 or 3");
    }

    /**
     * Swaps two items in the array.
     *
     * @param arr input/output parameter containing the array of items to be swapped.
     * @param i   index of the item to be swap for the one with index j
     * @param j   index of the item to be swap for the one with index i
     */
    public void swap(int[] arr, int i, int j) {
        int tempItem = arr[i];
        arr[i] = arr[j];
        arr[j] = tempItem;
    }

    /**
     * Retrieves object containing index and value of the minimum and the maximum element in the array.
     *
     * @param arr the array to get the max and min from.
     * @return max and min information.
     */
    public static MinMaxInfo getMinAndMaxInfo(final int[] arr) {

        Integer minValue = Integer.MAX_VALUE;
        Integer maxValue = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (current > maxValue) {
                maxValue = current;
                maxIndex = i;

            }
            if (current < minValue) {
                minValue = current;
                minIndex = i;
            }

        }

        return MinMaxInfo.newBuilder()
                .minInfo(new Pair<>(minIndex, minValue))
                .maxInfo(new Pair<>(maxIndex, maxValue))
                .build();

    }

    public static void main(String[] args) throws IOException {

        final int[] testArray = {1,2,3};
        System.out.println(minimumSwaps(testArray));

    }
}
