package lotto.domain.wrapper;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private int number;

    public Number() {
    }

    public Number(int number) {
        if (isInRange(number)) {
            throw new IllegalArgumentException("숫자의 범위는 1~45입니다.");
        }

        this.number = number;
    }

    private boolean isInRange(int number) {
        return number < MIN || number > MAX;
    }

    public boolean compareWith(Number target) {
        return this.equals(target);
    }

    public int number() {
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
        return String.valueOf(number);
    }
}

