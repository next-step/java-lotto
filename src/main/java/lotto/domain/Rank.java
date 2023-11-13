package lotto.domain;

import java.util.Arrays;
import java.util.List;

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

    public static int countRankType(List<Rank> ranks, Rank targetRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == targetRank)
                .count();
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

    private boolean isEqualMatchCount(int userMatchCount) {
        return userMatchCount == this.matchCount;
    }
}
