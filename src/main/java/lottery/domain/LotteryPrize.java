package lottery.domain;

import java.util.Arrays;
import java.util.List;

import static lottery.Constant.LOTTERY_TICKET_PRICE;

public enum LotteryPrize {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int matchingCount;
    private final int prizeMoney;

    LotteryPrize(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LotteryPrize of(int matchingCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public static double calculateProfitRate(List<LotteryPrize> lotteryPrizes) {
        int totalPrizeMoney = lotteryPrizes.stream()
                .mapToInt(LotteryPrize::calculatePrizeMoney)
                .sum();
        return (double) totalPrizeMoney / (LOTTERY_TICKET_PRICE * lotteryPrizes.size());
    }

    public int calculateMatchingCount() {
        return matchingCount;
    }

    public int calculatePrizeMoney() {
        return prizeMoney;
    }
}
