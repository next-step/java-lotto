package com.cheolhyeonpark.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5,true, 30000000),
    THIRD(5,false, 1500000),
    FOURTH(4,false, 50000),
    FIFTH(3,false, 5000),
    NONE(0,false, 0);

    private final int count;
    private final boolean hasBonus;
    private final int price;

    Rank(int count, boolean hasBonus, int price) {
        this.count = count;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getPrice() {
        return price;
    }

    public static Rank findRank(int count, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.getCount() == count && rank.hasBonus() == hasBonus)
                .findFirst()
                .orElse(NONE);
    }
}
