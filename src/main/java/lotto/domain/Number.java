package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int SAVED_MIN_NUMBER = 1;
    public static final int SAVED_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE = "로또 번호는 1이상 45이하의 수만 들어올 수 있다.";

    private final int number;

    public Number(int number) {
        checkNumberRange(number);

        this.number = number;
    }

    private static void checkNumberRange(int number) {
        if (!isNumberRange(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isNumberRange(int num) {
        return num >= SAVED_MIN_NUMBER && num <= SAVED_MAX_NUMBER;
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
    public int compareTo(Number o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
