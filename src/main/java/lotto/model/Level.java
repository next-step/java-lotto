package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum Level {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0),
    BONUS(7, 30000000);

    private final long value;
    private final long amount;

    Level(long value, long amount) {
        this.value = value;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public static Level valueOf(long value) {

        return Arrays.stream(Level.values())
                .filter(it -> it.value == value)
                .findFirst().get();
    }
}
