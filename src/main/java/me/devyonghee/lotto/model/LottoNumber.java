package me.devyonghee.lotto.model;

import java.util.Objects;

public final class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String INVALID_RANGE_NUMBER_ERROR_FORMAT = "lotto number(%d) must between %d and %d";

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateNumber(int number) {
        if (lessThanMinNumber(number) || greaterThanMaxNumber(number)) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_NUMBER_ERROR_FORMAT, number, MIN_NUMBER, MAX_NUMBER));
        }
    }

    private boolean lessThanMinNumber(int number) {
        return number < MIN_NUMBER;
    }

    private boolean greaterThanMaxNumber(int number) {
        return MAX_NUMBER < number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }
}
