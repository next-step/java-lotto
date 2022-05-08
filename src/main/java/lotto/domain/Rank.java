package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, 2000000000),
    TWO(5, 1500000),
    THREE(4, 50000),
    FOUR(3, 5000),
    NOT_MATCH(0, 0);

    private int count;
    private int money;

    Rank(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static Rank of(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameCount(count))
                .findFirst()
                .orElse(NOT_MATCH);
    }

    private boolean isSameCount(int count) {
        return this.count == count;
    }

    public int getMoney() {
        return this.money;
    }


}
