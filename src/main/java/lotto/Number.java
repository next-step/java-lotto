package lotto;

import java.util.Objects;

public class Number {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public Number(int number) {
        this.number = validRange(number);
    }

    private int validRange(int number) {
        if (isValidRange(number)) {
            throw new IllegalArgumentException("숫자는 1 ~ 45 사이의 값만 가질수 있습니다. : " + number);
        }
        return number;
    }

    private boolean isValidRange(int number) {
        return !(MIN_NUMBER <= number && number <= MAX_NUMBER);
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
