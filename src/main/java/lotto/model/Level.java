package lotto.model;

import java.util.Arrays;

public enum Level {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    SIXTH(0, 0);

    private final long value;
    private final long amount;

    Level(long value, long amount) {
        this.value = value;
        this.amount = amount;
    }

    public long getValue() {
        return value;
    }

    public long getAmount() {
        return amount;
    }

    public static Level hitCount(long value) {
        return Arrays.stream(Level.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }
}
