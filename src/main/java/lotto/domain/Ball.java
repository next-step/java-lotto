package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    static final int MAX_NUMBER = 45;
    static final int MIN_NUMBER = 1;
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE =
            "로또 숫자는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + "의 범위를 가질 수 있습니다.";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";

    private final int value;

    public Ball(final int value) {
        this(String.valueOf(value));
    }

    public Ball(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        validateNumeric(value);
        validateRangeOfNumber(Integer.parseInt(value));
    }

    private void validateNumeric(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void validateRangeOfNumber(final int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ball ball = (Ball) o;

        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Ball o) {
        return this.value - o.value;
    }
}
