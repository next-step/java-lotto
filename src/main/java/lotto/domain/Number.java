package lotto.domain;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isValidRange() {
        return value >= 1 && value <= 45;
    }

    public boolean isSmallerThan(Number other) {
        return value < other.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int value() {
        return value;
    }
}
