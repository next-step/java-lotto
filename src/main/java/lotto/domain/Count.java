package lotto.domain;

import java.util.Objects;

public class Count {
    private static int MIN = 0;

    private final int value;

    public Count(int value) {
        if (value < MIN) {
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
