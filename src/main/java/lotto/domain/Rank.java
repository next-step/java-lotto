package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0),
    ;

    private final int matchCount;
    private final long winningPrice;

    Rank(int matchCount, long winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Rank findRank(int userMatchCount, boolean isWinningBonus) {
        if (isSecondRank(userMatchCount, isWinningBonus)) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(Rank::isNotSecondRank)
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

    public boolean isBonusRank() {
        return this == SECOND;
    }

    private boolean isEqualMatchCount(int userMatchCount) {
        return userMatchCount == this.matchCount;
    }

    private static boolean isSecondRank(int userMatchCount, boolean isWinningBonus) {
        return userMatchCount == SECOND.matchCount && isWinningBonus;
    }

    private boolean isNotSecondRank() {
        return this != SECOND;
    }
}
