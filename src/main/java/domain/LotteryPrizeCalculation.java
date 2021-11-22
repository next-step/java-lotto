package domain;

import java.util.Arrays;

public enum LotteryPrizeCalculation {
    FIRST_RANK_PRIZE(6, 0, 2_000_000_000),
    SECOND_RANK_PRIZE(5, 1, 30_000_000),
    THIRD_RANK_PRIZE(5, 0, 1_500_000),
    FOURTH_RANK_PRIZE(4, 0, 50_000),
    FIFTH_RANK_PRIZE(3, 0, 5_000),
    ZERO_RANK_PRIZE(0, 0, 0);

    private static final String RANK_ERROR_MESSAGE = "error : 당첨 개수를 확인해주세요.";
    private static final int WINNING_NUMBER_MIN = 3;
    private static final int WINNING_NUMBER_ZERO = 0;

    private final int rank;
    private final int bonusBall;
    private final int money;

    LotteryPrizeCalculation(int rank, int bonusBall, int money) {
        this.rank = rank;
        this.bonusBall = bonusBall;
        this.money = money;
    }

    public static int winningAmount(int rank, int bonusBall) {
        return getRank(validWinningNumber(rank), bonusBall).money;
    }

    private static int validWinningNumber(int rank) {
        if (rank < WINNING_NUMBER_MIN) {
            return WINNING_NUMBER_ZERO;
        }
        return rank;
    }

    private static LotteryPrizeCalculation getRank(int rank, int bonusBall) {
        return Arrays.stream(values())
                .filter(lottery -> validRank(lottery.rank, rank, lottery.bonusBall, bonusBall))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
    }

    private static boolean validRank(int lotteryRank, int rank, int lotteryBonus, int bonus) {
        if (lotteryRank == rank && lotteryBonus == bonus) {
            return true;
        }
        return false;
    }
}
