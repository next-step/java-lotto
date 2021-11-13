package calculator;

import java.util.Objects;

public class Positive {

    public static final String NON_POSITIVE_ERROR_MESSAGE = "양수만 가능합니다.";

    private static final int MIN_POSITIVE = 1;

    private final int number;

    public static Positive from(String stringNum) {
        return new Positive(parse(stringNum));
    }

    private static int parse(String stringNum) {
        try {
            return Integer.parseInt(stringNum);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NON_POSITIVE_ERROR_MESSAGE);
        }
    }

    public Positive(int number) {
        checkPositive(number);
        this.number = number;
    }

    private void checkPositive(int num) {
        if (num < MIN_POSITIVE) {
            throw new RuntimeException(NON_POSITIVE_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
