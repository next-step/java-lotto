package lotto.model;

import java.util.Objects;

public class Number implements Comparable<Number> {

    static final int MIN = 1;
    static final int MAX = 45;

    private int number;

    public Number(int number) {
        verifyNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void verifyNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~45 범위에서만 생성 가능 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number number) {
        return this.number - number.number;
    }
}
