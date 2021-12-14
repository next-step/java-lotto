package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 1_500_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchedCount;
    private final boolean matchedBonus;
    private final int winningAmount;

    Rank(int matchedCount, boolean matchedBonus, int winningAmount) {
        this.matchedCount = matchedCount;
        this.matchedBonus = matchedBonus;
        this.winningAmount = winningAmount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int winningAmount() {
        return winningAmount;
    }

    public static Rank valueOf(int matchedCount, boolean matchedBonus) {
        if (isSecond(matchedCount, matchedBonus)) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank != Rank.SECOND && rank.matchedCount == matchedCount)
                .findFirst()
                .orElseGet(() -> Rank.MISS);
    }

    private static boolean isSecond(int matchedCount, boolean matchedBonus) {
        return Rank.SECOND.matchedCount == matchedCount && Rank.SECOND.matchedBonus == matchedBonus;
    }

}