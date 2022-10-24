package calculator.domain;

import static calculator.exception.ExceptionMessage.ERROR_EMPTY_VALUE;
import static calculator.exception.ExceptionMessage.ERROR_INVALID_VALUE_TO_CONVERT;
import static calculator.exception.ExceptionMessage.ERROR_NEGATIVE_VALUE;
import static java.lang.Integer.parseInt;

import java.util.Objects;
import java.util.regex.Pattern;

public class PositiveInt {

    private static final String POSITIVE_INT_PATTERN = "[0-9]";
    private static final int NEGATIVE_BOUND = 0;

    private final int value;

    public PositiveInt(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE.getMessage());
        }
        this.value = value;
    }

    public static PositiveInt from(final String value) {
        validateToParse(value);

        return new PositiveInt(parseInt(value));
    }

    private static void validateToParse(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE.getMessage());
        }

        if (!Pattern.matches(POSITIVE_INT_PATTERN, value)) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE_TO_CONVERT.getMessage());
        }
    }

    public PositiveInt calculate(PositiveInt y, Operator o) {
        return new PositiveInt(o.execute(this.value, y.value));
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PositiveInt)) {
            return false;
        }

        return this.value == ((PositiveInt) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
