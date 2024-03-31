package lottogame.domain;

import java.util.Objects;

public final class Number {

    private final int value;

    private Number(final int value) {
        this.value = value;
    }

    public static Number from(final int number) {
        return new Number(number);
    }

    public static Number from(final String value) {
        validateNumber(value);
        return new Number(Integer.parseInt(value));

    }

    public Number divide(Number number) {
        return new Number(value / number.value);
    }

    public Number add(Number number) {
        return new Number(value + number.value);
    }

    public boolean isPositive() {
        return value > 0;
    }

    public Number decrease() {
        return new Number(value - 1);
    }

    public Number multiply(Number count) {
        return new Number(value * count.value);
    }

    public int intValue() {
        return value;
    }

    private static void validateNumber(String value) {
        Integer.parseInt(value);
    }

    public Number minus(Number number) {
        return from(value - number.value);
    }

    public boolean isLessThan(Number number) {
        return value < number.value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
