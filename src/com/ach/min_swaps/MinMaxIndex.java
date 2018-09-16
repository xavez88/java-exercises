package com.ach.min_swaps; /**
 * Created by antoniochavez on 16/09/2018.
 */

import javafx.util.Pair;

/**
 * Class to keep information about Max and Min elements in an array.
 */
public class MinMaxIndex {

    private int minIndex;
    private int maxIndex;

    private MinMaxIndex(Builder builder) {
        minIndex = builder.minIndex;
        maxIndex = builder.maxIndex;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMinIndex() {
        return minIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }


    /**
     * Retrieves object containing index and value of the minimum and the maximum element in the array.
     *
     * @param arr the array to get the max and min from.
     * @return max and min information.
     */
    public static MinMaxIndex getMinAndMaxIndexes(final int[] arr) {

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

        return MinMaxIndex.newBuilder()
                .minIndex(minIndex)
                .maxIndex(maxIndex)
                .build();

    }

    public static int getMaxIndex(final int[] arr) {

        Integer maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (current > maxValue) {
                maxValue = current;
                maxIndex = i;

            }

        }

        return maxIndex;

    }

    public static final class Builder {
        private int minIndex;
        private int maxIndex;

        private Builder() {
        }

        public Builder minIndex(int val) {
            minIndex = val;
            return this;
        }

        public Builder maxIndex(int val) {
            maxIndex = val;
            return this;
        }

        public MinMaxIndex build() {
            return new MinMaxIndex(this);
        }
    }
}
