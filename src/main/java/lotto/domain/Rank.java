package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final long winningPrice;
    private final boolean isBonus;

    Rank(int matchCount, long winningPrice, boolean isBonus) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
        this.isBonus = isBonus;
    }

    public static Rank findRank(int userMatchCount, boolean isBonusWinning) {
        return Arrays.stream(values())
                .filter(rank -> rank.isEqualMatchCount(userMatchCount, isBonusWinning))
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

    public boolean isBonus() {
        return isBonus;
    }

    private boolean isEqualMatchCount(int userMatchCount, boolean isBonus) {
        return userMatchCount == this.matchCount && eqaulBonusCondition(isBonus);
    }

    private boolean eqaulBonusCondition(boolean isBonus) {
        if (this.isBonus) {
            return isBonus;
        }
        return true;
    }
}
