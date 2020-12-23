package lotto;

import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;
    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number newNumber(int value) {
        if (value > LOTTO_NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("로또 번호는 45보다 클 수 없습니다.");
        }

        if (value < LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException("로또 번호는 1보다 작을 수 없습니다.");
        }

        return new Number(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Number anotherValue) {
        return (Integer.compare(this.value, anotherValue.value));
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

    @Override
    public String toString() {
        return value + "";
    }
}