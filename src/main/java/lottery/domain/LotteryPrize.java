package lottery.domain;

import java.util.Arrays;
import java.util.List;

public enum LotteryPrize {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
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
        return totalPrizeMoney / (1000.0 * lotteryPrizes.size());
    }

    public int calculateMatchingCount() {
        return matchingCount;
    }

    public int calculatePrizeMoney() {
        return prizeMoney;
    }
}
