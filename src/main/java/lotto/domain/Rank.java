package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

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
                .orElseThrow(() -> new IllegalArgumentException("해당 하는 등수가 존재하지 않습니다."));
    }

    public static int countRankType(List<Rank> ranks, Rank targetRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == targetRank)
                .count();
    }

    public static int getMinMatchCount() {
        return Arrays.stream(Rank.values())
                .mapToInt(Rank::getMatchCount)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("최소 당첨 숫자가 없습니다."));
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
