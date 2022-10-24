package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_EMPTY_VALUE;
import static lotto.exception.ExceptionMessage.ERROR_INVALID_VALUE_TO_CONVERT;
import static lotto.exception.ExceptionMessage.ERROR_OUT_OF_LOTTO_NUMBER_BOUND;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String VALID_VALUE_PATTERN = "[0-9]+";
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int value;

    public LottoNumber(final int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(final int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(ERROR_OUT_OF_LOTTO_NUMBER_BOUND.getMessage());
        }
    }

    public static LottoNumber from(final String value) {
        validateToParse(value);
        return new LottoNumber(Integer.parseInt(value.trim()));
    }

    private static void validateToParse(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE.getMessage());
        }

        if (!Pattern.matches(VALID_VALUE_PATTERN, value.trim())) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE_TO_CONVERT.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LottoNumber)) {
            return false;
        }

        return this.value == ((LottoNumber) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
