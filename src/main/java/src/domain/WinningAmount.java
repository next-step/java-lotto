package src.domain;

import java.util.Arrays;

public enum WinningAmount {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    OTHER(2, 0);

    final int matchedCount;

    final double amount;

    WinningAmount(int matchedCount, double amount) {
        this.matchedCount = matchedCount;
        this.amount = amount;
    }

    public static WinningAmount byMatchedCount(int matchedCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchedCount == matchedCount)
                .findFirst()
                .orElse(WinningAmount.OTHER);
    }
}
