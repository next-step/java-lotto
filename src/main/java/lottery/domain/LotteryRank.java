package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {
    FIRST_PRIZE(6, 0, 2_000_000_000),
    SECOND_PRIZE(5, 1, 30_000_000),
    THIRD_PRIZE(5, 0, 1_500_000),
    FOURTH_PRIZE(4, 0, 50_000),
    FIFTH_PRIZE(3, 0, 5_000),
    MISS(0, 0, 0);

    private final int matchNumberCounts;
    private final int bonusBallCount;
    private final long prizeMoney;

    private LotteryRank(int matchNumberCounts, int bonusBallCount, long prizeMoney) {
        this.matchNumberCounts = matchNumberCounts;
        this.bonusBallCount = bonusBallCount;
        this.prizeMoney = prizeMoney;
    }

    public static LotteryRank valueOf(int matchNumberCounts, int bonusBallCount) {
        validateMatchNumberCounts(matchNumberCounts);
        validateBonusBallCount(bonusBallCount);
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.matchNumberCounts <= matchNumberCounts)
                .filter(lotteryRank -> lotteryRank.bonusBallCount <= bonusBallCount)
                .findFirst()
                .orElse(MISS);
    }

    private static void validateMatchNumberCounts(int matchNumberCounts) {
        if (matchNumberCounts < MISS.matchNumberCounts || matchNumberCounts > FIRST_PRIZE.matchNumberCounts) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MATCH_NUMBER_COUNTS);
        }
    }

    private static void validateBonusBallCount(int bonusBallCount) {
        if (bonusBallCount < MISS.bonusBallCount || bonusBallCount > SECOND_PRIZE.bonusBallCount) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_BALL_COUNT);
        }
    }

    public double calculatePrizeMoneySum(int winnerTicketCounts) {
        return (double) prizeMoney * winnerTicketCounts;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumberCounts() {
        return matchNumberCounts;
    }
}
