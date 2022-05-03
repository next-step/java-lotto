package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OTHER(0, 0);

    private final int matchCount;
    private final long winnings;

    Rank(int matchCount, long winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int matchCount() {
        return matchCount;
    }

    public long winnings() {
        return winnings;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(OTHER);
    }
}
