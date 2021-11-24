package lotto.model;

import java.util.Arrays;

public enum Match {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

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

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
