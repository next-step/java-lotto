package calculator.model;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    Number minus(Number number) {
        return new Number(this.value - number.value);
    }

    Number multiply(Number number) {
        return new Number(this.value * number.value);
    }

    Number divide(Number number) {
        if (!isDividableBy(number)) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
        }
        return new Number(this.value / number.value);
    }

    private boolean isDividableBy(Number number) {
        return this.value % number.value == 0;
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
}
