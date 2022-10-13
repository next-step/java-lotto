package number;

import static java.lang.Integer.parseInt;

import java.util.Objects;
import java.util.regex.Pattern;

public class PositiveInt {

    private static final String POSITIVE_INT_PATTERN = "[0-9]";
    private static final int NEGATIVE_BOUND = 0;

    private final int value;

    public PositiveInt(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException("허용되지 않는 값이 존재합니다.");
        }
        this.value = value;
    }

    public static PositiveInt from(final String value) {
        if (isImpossibleToParse(value)) {
            throw new IllegalArgumentException("허용하지 않는 값이 존재합니다.");
        }

        return new PositiveInt(parseInt(value));
    }

    private static boolean isImpossibleToParse(final String input) {
        return !Pattern.matches(POSITIVE_INT_PATTERN, input);
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

        return this.value != ((PositiveInt) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
