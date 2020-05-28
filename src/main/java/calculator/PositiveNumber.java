package calculator;

import java.util.Objects;

public class PositiveNumber {
    private final int value;

    private PositiveNumber(int value) {
        this.value = value;
    }

    public static PositiveNumber of(String value) {
        if (value == null || value.isEmpty()) {
            throw new NumberFormatException("``value` is must not be null or empty");
        }
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new NumberFormatException("``value` is must be positive number");
        }
        return new PositiveNumber(number);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
