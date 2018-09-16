package com.ach.min_swaps; /**
 * Created by antoniochavez on 16/09/2018.
 */

import javafx.util.Pair;

/**
 * Class to keep information about Max and Min elements in an array.
 */
public class MinMaxInfo {
    private Pair<Integer, Integer> minInfo;
    private Pair<Integer, Integer> maxInfo;

    private MinMaxInfo(Builder builder) {
        minInfo = builder.minInfo;
        maxInfo = builder.maxInfo;
    }

    public Pair<Integer, Integer> getMinInfo() {
        return minInfo;
    }

    public Pair<Integer, Integer> getMaxInfo() {
        return maxInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Pair<Integer, Integer> minInfo;
        private Pair<Integer, Integer> maxInfo;

        private Builder() {
        }

        public Builder minInfo(Pair<Integer, Integer> val) {
            minInfo = val;
            return this;
        }

        public Builder maxInfo(Pair<Integer, Integer> val) {
            maxInfo = val;
            return this;
        }

        public MinMaxInfo build() {
            return new MinMaxInfo(this);
        }
    }
}
