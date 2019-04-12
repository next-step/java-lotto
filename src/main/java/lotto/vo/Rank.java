package lotto.vo;

import lotto.utils.Const;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    FAILURE(0, false, 0);

    public static final int MINIMUM_WINNING_NUMBER = 3;
    private int numberOfMatches, reward;
    private boolean isBonus;

    Rank(int numberOfMatches, boolean isBonus, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.isBonus = isBonus;
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

    public static Rank getRank(LotteryNumber winningNumber, LotteryNumber currentLottery) {
        return winningNumber.match(currentLottery);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }
}
