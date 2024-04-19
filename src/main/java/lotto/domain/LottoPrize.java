package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    LottoPrize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static int calculatePrize(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.getMatchCount() == matchCount)
                .findFirst()
                .map(LottoPrize::getPrizeAmount)
                .orElse(0);
    }
}

