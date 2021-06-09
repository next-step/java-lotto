package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    NOT_IN_RANK(0, false, 0);

    private static final int SECOND_PLACE_COUNT_CONDITION = 5;

    private int winningCount;
    private int winningPrize;
    private boolean secondJudgement;

    Rank(int winningCount, boolean secondJudgement, int winningPrize) {
        this.winningCount = winningCount;
        this.secondJudgement = secondJudgement;
        this.winningPrize = winningPrize;
    }

    public static Rank findLottoRank(int winningCount, boolean bonusBall) {
        if (winningCount == SECOND_PLACE_COUNT_CONDITION) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> rank.hasWinningCount(winningCount) &&
                            rank.hasWinningBonus(bonusBall))
                    .findFirst()
                    .orElse(NOT_IN_RANK);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hasWinningCount(winningCount))
                .findFirst()
                .orElse(NOT_IN_RANK);
    }

    private boolean hasWinningCount(int winningCount) {
        return this.winningCount == winningCount;
    }

    private boolean hasWinningBonus(boolean bonusBall) {
        return this.secondJudgement == bonusBall;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
