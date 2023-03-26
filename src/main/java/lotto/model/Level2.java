package lotto.model;

import java.util.Arrays;

public enum Level2 {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    SIXTH(0, 0);

    private final long value;
    private final long amount;

    Level2(long value, long amount) {
        this.value = value;
        this.amount = amount;
    }

    public long getValue() {
        return value;
    }

    public long getAmount() {
        return amount;
    }

    public static Level2 hitCount(long value) {
        return Arrays.stream(Level2.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }
}
