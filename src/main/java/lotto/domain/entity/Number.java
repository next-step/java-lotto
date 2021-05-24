package lotto.domain.entity;

import java.util.Objects;

public final class Number implements Comparable<Number> {

    private final int number;

    public Number(int number) {
        if (1 > number || number > 45) {
            throw new IllegalArgumentException("로또 숫자 범위는 1 ~ 45 사이입니다.");
        }
        this.number = number;
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(Number number) {
        return getNumber() - number.getNumber();
    }
}
