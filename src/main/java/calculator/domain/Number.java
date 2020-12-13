package calculator.domain;

import java.util.Objects;

public class Number {

    private static final String NEGATIVE_VALUE_INCLUDE_ERROR = "문자열에 음수값이 포함되어 있습니다.";
    private static final int ZERO = 0;
    private final int value;

    private Number(int value) {
        validatePositiveNumber(value);
        this.value = value;
    }

    private void validatePositiveNumber(int value) {
        if (value < ZERO) {
            throw new RuntimeException(NEGATIVE_VALUE_INCLUDE_ERROR);
        }
    }

    public static Number of(String value) {
        return new Number(Integer.parseInt(value));
    }

    public static Number zero() {
        return new Number(ZERO);
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
