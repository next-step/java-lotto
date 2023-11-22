package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public enum LottoCashPrize {
    COLLECT_0(0,0),
    COLLECT_1(1,0),
    COLLECT_2(2,0),
    COLLECT_3(3,5000),
    COLLECT_4(4,50000),
    COLLECT_5(5,1500000),
    COLLECT_6(6,2000000000);

    private static final String ERR_INVALID_MATCH_COUNT = "The number of matched lotto numbers cannot exceed 6, as there are a total of 6 lotto numbers.";
    private final int matchCount;
    private final int cashPrize;

    LottoCashPrize(int matchCount, int cash) {
        this.matchCount = matchCount;
        this.cashPrize = cash;
    }

    public static int calculateTotalPrize(List<Integer> matchResult) {
        return IntStream.range(0,7)
                .map(i -> calculatePrize(i, matchResult.get(i)))
                .sum();
    }

    private static int calculatePrize(int matchedNumbersCount, int matchingTicketsCount) {
        return getByMatchCount(matchedNumbersCount).cashPrize * matchingTicketsCount;
    }

    public static LottoCashPrize getByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(cashPrize -> cashPrize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_MATCH_COUNT));
    }

    public int cashPrize() {
        return this.cashPrize;
    }
}
