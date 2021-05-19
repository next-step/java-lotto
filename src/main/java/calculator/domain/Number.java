package calculator.domain;

import java.util.Objects;

public class Number {
    private final int number;

    private Number(final int number) {
        this.number = number;
    }

    public static Number from(final int number) {
        validateNegative(number);
        return new Number(number);
    }

    private static void validateNegative(final int number) {
        if (number < 0) {
            throw new RuntimeException("Negative numbers are not possible");
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
