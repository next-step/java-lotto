package calculator;

import java.util.Objects;

public class Number {
    
    public static final int MIN_NUMBER = 0;
    public static final String NOT_NUMBER_ERROR_MESSAGE = MIN_NUMBER + "이상의 정수만 가능합니다";

    private final int number;

    public static Number from(String expression) {
        return new Number(parse(expression));
    }

    private static int parse(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public Number(int number) {
        checkPositive(number);
        this.number = number;
    }

    private void checkPositive(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public Number plus(Number other) {
        checkNotNull(other);
        return new Number(this.number + other.number);
    }

    private void checkNotNull(Number other) {
        if (other == null) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
