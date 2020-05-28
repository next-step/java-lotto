package com.cheolhyeonpark.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int count;
    private final int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static Rank findRank(int count) {
        return Arrays.stream(values()).filter(rank -> rank.getCount() == count).findFirst().orElse(NONE);
    }
}
