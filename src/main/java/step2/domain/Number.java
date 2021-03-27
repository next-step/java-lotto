package step2.domain;

import step2.constants.Constants;

import java.util.Objects;

public class Number {
    private final int number;

    private Number(final int number) {
        this.number = number;
    }

    public static Number from(final int number) {
        if (number < Constants.LOTTO_MIN_BOUND || number > Constants.LOTTO_MAX_BOUND) {
            throw new RuntimeException("로또에서 가능한 범위를 초과한 숫자입니다.");
        }
        return new Number(number);
    }

    public int getNumber() {
        return number;
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
