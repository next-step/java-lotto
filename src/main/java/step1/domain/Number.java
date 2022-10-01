package step1.domain;

import java.util.Objects;

public class Number {
    private static final String DIVISION_BY_ZERO_EXCEPTION_MESSAGE = "0으로 나누기를 시도하였습니다.";

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    public Number add(Number other) {
        return new Number(this.number + other.number);
    }

    public Number subtract(Number other) {
        return new Number(this.number - other.number);
    }

    public Number multiply(Number other) {
        return new Number(this.number * other.number);
    }

    public Number divide(Number other) {
        if (other.number == 0) {
            throw new ArithmeticException(DIVISION_BY_ZERO_EXCEPTION_MESSAGE);
        }

        return new Number(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Number number1 = (Number)o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
