package lotto.domain;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private int number;

    public Number(final int number) {

        validate(number);
        this.number = number;
    }

    private void validate(final int number) {

        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 숫자는 1 ~ 45 사이여야 합니다.");
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

    @Override
    public String toString() {

        return "" + number + "";
    }
}
