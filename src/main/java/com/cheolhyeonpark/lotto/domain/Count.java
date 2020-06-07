package com.cheolhyeonpark.lotto.domain;

public class Count {

    private final int count;

    public Count(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (isUnderZero(count)) {
            throw new IllegalArgumentException("Count must be positive.");
        }
    }

    private boolean isUnderZero(int count) {
        return count < 0;
    }

    public int getRemainCount(int totalCount) {
        return totalCount - count;
    }

    public int getCount() {
        return count;
    }
}
