package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, 2000000000),
    TWO(5, 30000000),
    THREE(5, 1500000),
    FOUR(4, 50000),
    FIVE(3, 5000),
    NOT_MATCH(0, 0);

    private int count;
    private int money;

    Rank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static Rank of(int count, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameCount(count, isBonus))
                .findFirst()
                .orElse(NOT_MATCH);

    }

    private boolean isSameCount(int count, boolean isBonus) {
        if (this == TWO && !isBonus) {
            return false;
        }

        return this.count == count;
    }

    public int getMoney() {
        return this.money;
    }


}
