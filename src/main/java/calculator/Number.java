package calculator;

import calculator.exception.InvalidNumberException;

import java.util.Objects;

public class Number {
    private static final int ZERO = 0;
    private int value;

    private Number(final int number) {
        checkNegative(number);
        this.value = number;
    }

    public static Number valueOf(final String letter) {
        return new Number(parse(letter));
    }

    private static int parse(String letter) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(letter);
        } catch (NumberFormatException ne) {
            throw new InvalidNumberException(letter);
        }
        return parseInt;
    }

    private void checkNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException("음수 입니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
