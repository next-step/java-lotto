package domain;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum LotteryPrizeCalculation {
    FIRST_RANK_PRIZE(6, (a) -> a * 2_000_000_000),
    SECOND_RANK_PRIZE(5, (a) -> a * 1_500_000),
    THIRD_RANK_PRIZE(4, (a) -> a * 50_000),
    FOURTH_RANK_PRIZE(3, (a) -> a * 5_000),
    ZERO_RANK_PRIZE(0, (a) -> 0);

    private int rank;
    private UnaryOperator<Integer> count;

    private static final String RANK_ERROR_MESSAGE = "error : 당첨 개수를 확인해주세요.";
    private static final int WINNING_NUMBER_MIN = 3;
    private static final int WINNING_NUMBER_ZERO = 0;

    LotteryPrizeCalculation(int rank, UnaryOperator<Integer> winningCount) {
        this.rank = rank;
        this.count = winningCount;
    }

    public static int winningAmount(int rank, int count) {
        return getRank(validWinningNumber(rank)).count.apply(count);
    }

    private static int validWinningNumber(int rank) {
        if (rank < WINNING_NUMBER_MIN) {
            return WINNING_NUMBER_ZERO;
        }
        return rank;
    }

    private static LotteryPrizeCalculation getRank(int rank) {
        return Arrays.stream(values())
                .filter(lottery -> lottery.rank == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RANK_ERROR_MESSAGE));
    }
}
