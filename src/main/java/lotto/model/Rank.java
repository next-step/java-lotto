package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;

    private final long amount;

    Rank(int matchCount, long amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank valueOf(int count) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElse(MISS);
    }

    public boolean isMiss() {
        return this == Rank.MISS;
    }

}
