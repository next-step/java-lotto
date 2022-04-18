package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_1000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int count;

    private final long amount;

    Rank(int count, long amount) {
        this.count = count;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank valueOf(int count) {
        return Arrays.stream(values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(MISS);
    }

}
