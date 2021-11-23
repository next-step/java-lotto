package lotto.model;

import java.util.Arrays;

public enum Match {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchedCount;
    private final int price;

    Match(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static Match from(int matchedCount) {
        return Arrays.stream(values())
                     .filter(match -> match.matchedCount == matchedCount)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("not matched count."));
    }

    public int winningAmount(int matchedCount) {
        return this.price * matchedCount;
    }
}
