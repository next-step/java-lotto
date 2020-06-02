package lottery.domain;

import java.util.Arrays;

public enum LotteryRank {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchNumberCounts;
    private final long prizeMoney;
    private final boolean isContainingBonusBall;

    private LotteryRank(int matchNumberCounts, long prizeMoney, boolean isContainingBonusBall) {
        this.matchNumberCounts = matchNumberCounts;
        this.prizeMoney = prizeMoney;
        this.isContainingBonusBall = isContainingBonusBall;
    }

    public static LotteryRank valueOf(int matchNumberCounts, boolean isContainingBonusBall) {
        validateMatchNumberCounts(matchNumberCounts);
        boolean adjustedIsContainingBonusBall = adjustIsContainingBall(matchNumberCounts, isContainingBonusBall);
        return Arrays.stream(values())
                .filter(lotteryRank -> lotteryRank.matchNumberCounts == matchNumberCounts
                        && lotteryRank.isContainingBonusBall == adjustedIsContainingBonusBall)
                .findFirst()
                .orElse(MISS);
    }

    private static boolean adjustIsContainingBall(int matchNumberCounts, boolean isContainingBonusBall) {
        if (matchNumberCounts != SECOND_PRIZE.matchNumberCounts && isContainingBonusBall) {
            return false;
        }
        return isContainingBonusBall;
    }

    private static void validateMatchNumberCounts(int matchNumberCounts) {
        if (matchNumberCounts < MISS.matchNumberCounts || matchNumberCounts > FIRST_PRIZE.matchNumberCounts) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MATCH_NUMBER_COUNTS);
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
