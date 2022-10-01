package step1.domain;

import java.util.Objects;

public class Number {
    private static final String NEGATIVE_INTEGER_EXCEPTION_MESSAGE = "음수 값을 입력으로 받을 수 없습니다.";

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        validate(number);
        this.number = number;
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
        return new Number(this.number / other.number);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new NegativeIntegerException(NEGATIVE_INTEGER_EXCEPTION_MESSAGE, number);
        }
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
