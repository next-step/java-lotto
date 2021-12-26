package lotto.domain;

import java.util.Objects;

public class Count {
    private static int FIRST_POSITION = 0;
    private static int LAST_POSITION = 6;

    private final int value;

    public Count(int value) {
        if (value < FIRST_POSITION || value > LAST_POSITION) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public Count increasedCount() {
        return new Count(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Count)) return false;
        Count thatCount = (Count) o;
        return value == thatCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
