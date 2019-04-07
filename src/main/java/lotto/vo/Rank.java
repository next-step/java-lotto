package lotto.vo;

import lotto.utils.Const;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FAILURE(0, 0);

    public static final int MINIMUM_WINNING_NUMBER = 3;
    private int numberOfMatches, reward;

    Rank(int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    static Rank valueOf(int matchCount) {
        if (matchCount < MINIMUM_WINNING_NUMBER) {
            return FAILURE;
        }
        return Arrays.stream(values())
                .filter(v -> matchCount == v.numberOfMatches)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int sumProfit(Ranks ranks) {
        int sumProfit = Const.INITIAL_NUMBER;
        for (Rank rank : Rank.values()) {
            if (rank.getReward() > Const.INITIAL_NUMBER) {
                sumProfit += ranks.rankPerWinningCount(rank) * rank.getReward();
            }
        }
        return sumProfit;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }
}
