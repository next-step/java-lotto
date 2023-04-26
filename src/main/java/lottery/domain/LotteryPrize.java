package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lottery.domain.LotteryTicket.LOTTERY_TICKET_PRICE;

public enum LotteryPrize {
    NONE(0, 0, false),
    FOURTH(3, 5_000, false),
    THIRD(4, 50_000, false),
    SECOND(5, 1_500_000, false),
    SECOND_BONUS(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    ;

    private final int matchingCount;
    private final int prizeMoney;
    private final boolean isBonusMatched;

    LotteryPrize(int matchingCount, int prizeMoney, boolean isBonusMatched) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
        this.isBonusMatched = isBonusMatched;
    }

    public static LotteryPrize valueOf(int matchingCount, boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchingCount == matchingCount)
                .filter(prize -> !isBonusPrize(matchingCount) || prize.isBonusMatched == isBonusMatched)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isBonusPrize(int matchingCount) {
        return getBonusPrizes().stream()
                .anyMatch(prize -> prize.matchingCount == matchingCount);
    }


    private static List<LotteryPrize> getBonusPrizes() {
        return Arrays.stream(values())
                .filter(prize -> prize.isBonusMatched)
                .collect(Collectors.toList());
    }

    public static double calculateProfitRate(List<LotteryPrize> lotteryPrizes) {
        long totalPrizeMoney = lotteryPrizes.stream()
                .mapToLong(LotteryPrize::calculatePrizeMoney)
                .sum();
        return (double) totalPrizeMoney / (LOTTERY_TICKET_PRICE * lotteryPrizes.size());
    }

    public boolean IsBonusMatched() {
        return isBonusMatched;
    }

    public int calculateMatchingCount() {
        return matchingCount;
    }

    public long calculatePrizeMoney() {
        return prizeMoney;
    }
}
