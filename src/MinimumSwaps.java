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

        /* Let's resolve this by recursion:
            Base cases:
                - Array of two items: Even number of elements:
                    * If items are ordered -> 0 Swaps
                    * If items are unordered -> 1 Swap
                - Array of three items: Odd number of elements:
                    * If items are ordered -> 0 Swaps
                    * If min is NOT first AND max is NO last -> 2 Swaps: i.e [2,3,1] => [1,3,2] => [1,2,3];
                    *                                                        [3,1,2] => [1,3,2] => [1,2,3]
                    * Else -> 1 Swaps: i.e [1,3,2] => [1,2,3]; [2,1,3] => [1,2,3]
        */

        return 0;
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

    public class MinMaxInfo {
        private Pair<Integer, Integer> minInfo;
        private Pair<Integer, Integer> maxInfo;

        public MinMaxInfo(int minIndex, int minValue){
            
        }

        public Pair<Integer, Integer> getMaxInfo() {
            return maxInfo;
        }

        public Pair<Integer, Integer> getMinInfo() {
            return minInfo;
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
