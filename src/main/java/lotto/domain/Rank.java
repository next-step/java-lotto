package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    LOST(0, 0);

    private final int winningCount;
    private final int winnings;

    Rank(int winningCount, int winnings) {
        this.winningCount = winningCount;
        this.winnings = winnings;
    }

    public static Rank findRank(int winningCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isWinningCount(winningCount, rank))
                .findFirst()
                .orElse(Rank.LOST);
    }

    private static boolean isWinningCount(int winningCount, Rank rank) {
        return rank.winningCount == winningCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinnings() {
        return winnings;
    }
}