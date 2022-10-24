package domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0L),
    ONE(6, 2_000_000_000L),
    TWO(5, 1_500_000L),
    THREE(4, 50_000L),
    FOUR(3, 5_000L),
    FIVE(2, 0L),
    SIX(1, 0L);

    private final Integer equalCount;
    private final long winningPrice;

    Rank(int equalCount, long winningPrice) {
        this.equalCount = equalCount;
        this.winningPrice = winningPrice;
    }

    public long getWinningPrice() {
        return this.winningPrice;
    }

    public Integer getEqualCount() {
        return this.equalCount;
    }

    public static Rank of(long equalCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getEqualCount() == equalCount)
                .findAny()
                .orElseGet(() -> Rank.NONE);
    }

    public static long findWinningPrice(long equalCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getEqualCount() == equalCount)
                .map(rank -> rank.getWinningPrice())
                .findAny()
                .orElse(0L);
    }
}
