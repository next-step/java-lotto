package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchedCount;
    private final int price;

    Rank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static Rank from(int matchedCount) {
        return Arrays.stream(values())
                     .filter(rank -> rank.matchedCount == matchedCount)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("not matched count."));
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
