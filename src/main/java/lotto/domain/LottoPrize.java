package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final long amount;

    LottoPrize(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static long getWinningAmount(int count) {

        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == count)
                .findFirst()
                .map(prize -> prize.amount)
                .orElse(0L);
    }
}
