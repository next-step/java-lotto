package lotto.common;

import java.util.Objects;

public class PositiveNumber {
    private long number;

    private PositiveNumber(long number) {
        validate(number);
        this.number = number;
    }

    public static PositiveNumber of(long number) {
        return new PositiveNumber(number);
    }

    private void validate(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number range");
        }
    }

    public long get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}