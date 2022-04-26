package me.devyonghee.lotto.model;

import java.util.Objects;

public final class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final String INVALID_RANGE_NUMBER_ERROR_MESSAGE_FORMAT = "lotto number(%d) must between %d and %d";
    private static final String INVALID_FORMAT_NUMBER_ERROR_MESSAGE = "lotto number(%s) must be number format";
    private static final String TO_STRING_START = "LottoNumber{";
    private static final String TO_STRING_NUMBER_FIELD = "number=";
    private static final char TO_STRING_END = '}';
    private static final String NULL_NUMBER_ERROR_MESSAGE = "number must not be null";

    private final int number;

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    static LottoNumber from(String number) {
        return new LottoNumber(parseInt(number));
    }

    private static int parseInt(String number) {
        Objects.requireNonNull(number, NULL_NUMBER_ERROR_MESSAGE);
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new NumberFormatException(String.format(INVALID_FORMAT_NUMBER_ERROR_MESSAGE, number));
        }
        return Integer.parseInt(number);
    }

    public int number() {
        return number;
    }

    private void validateNumber(int number) {
        if (lessThanMinNumber(number) || greaterThanMaxNumber(number)) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_NUMBER_ERROR_MESSAGE_FORMAT, number, MIN_NUMBER, MAX_NUMBER));
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

    @Override
    public String toString() {
        return TO_STRING_START +
                TO_STRING_NUMBER_FIELD + number +
                TO_STRING_END;
    }
}
