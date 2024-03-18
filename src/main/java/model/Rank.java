package model;

import java.util.Arrays;

public enum Rank {

    NONE(0, 0),
    FIRST(2_000_000_000, 6),
    SECOND(150_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3);

    private final int amount;
    private final int matchingCount;

    Rank(final int amount, final int matchingCount) {
        this.amount = amount;
        this.matchingCount = matchingCount;
    }

    public static Rank determine(final int count) {
        return Arrays.stream(Rank.values())
                .filter(winningPrice -> winningPrice.matchingCount == count)
                .findFirst()
                .orElse(NONE);
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
