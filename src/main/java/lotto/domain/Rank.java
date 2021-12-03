package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    TRIO(3, 5_000),
    QUARTET(4, 50_000),
    QUINTET(5, 1_500_000),
    SEXTET(6, 2_000_000_000);

    private final int count;
    private final int amount;

    Rank(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static Rank getRank(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getCount() == count)
                .findAny()
                .orElse(Rank.NONE);
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

}
