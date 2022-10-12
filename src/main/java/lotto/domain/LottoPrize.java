package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int amount;

    LottoPrize(final int matchCount, final int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int matchCount() {
        return matchCount;
    }

    public int amount() {
        return amount;
    }

    public static LottoPrize from(final int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}