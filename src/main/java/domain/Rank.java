package domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, false, 0L),
    ONE(6, false, 2_000_000_000L),
    TWO(5, true, 30_000_000L),
    THREE(5, false, 1_500_000L),
    FOUR(4, false, 50_000L),
    FIVE(3, false, 5_000L),
    SIX(2, false, 0L),
    SEVEN(1, false, 0L);

    private final Integer equalCount;
    private final boolean equalBonus;
    private final long winningPrice;

    Rank(int equalCount, boolean equalBonus, long winningPrice) {
        this.equalCount = equalCount;
        this.equalBonus = equalBonus;
        this.winningPrice = winningPrice;
    }

    public long getWinningPrice() {
        return this.winningPrice;
    }

    public Integer getEqualCount() {
        return this.equalCount;
    }

    public boolean getEqualBonus() {
        return this.equalBonus;
    }

    public static Rank of(long equalCount, boolean equalBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getEqualCount() == equalCount && rank.getEqualBonus() == equalBonus)
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
