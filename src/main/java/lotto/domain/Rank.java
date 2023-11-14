package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final long winningPrice;

    Rank(int matchCount, long winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Rank findRank(int userMatchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isEqualMatchCount(userMatchCount))
                .findFirst()
                .orElse(NONE);
    }

    public boolean isWinningRank() {
        return this != NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinningPrice() {
        return this.winningPrice;
    }

    public long sumWinningPrice(long winningCount) {
        return this.winningPrice * winningCount;
    }

    private boolean isEqualMatchCount(int userMatchCount) {
        return userMatchCount == this.matchCount;
    }
}
