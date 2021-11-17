package lotto.domain;

import java.util.Objects;

public class Positive {

    public static final String NOT_POSITIVE_ERROR_MESSAGE = "양수만 가능합니다.";
    public static final String INVALID_RANGE_ERROR_MESSAGE = "범위 밖에 있습니다.";
    private static final int MIN_VALUE = 1;

    private final int value;

    public Positive(int value) {
        checkPositive(value);
        this.value = value;
    }

    private void checkPositive(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    public void checkRange(int start, int end) {
        if (value < start || value > end) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
