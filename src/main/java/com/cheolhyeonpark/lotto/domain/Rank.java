package com.cheolhyeonpark.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    NONE(0);

    private final int count;

    Rank(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static Rank findRank(int count) {
        return Arrays.stream(values()).filter(rank -> rank.getCount() == count).findFirst().orElse(NONE);
    }
}
