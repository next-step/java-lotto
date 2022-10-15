package calculator.number;

import static java.lang.Integer.parseInt;

import java.util.Objects;
import java.util.regex.Pattern;
import calculator.operator.Operator;

public class PositiveInt {

    private static final String POSITIVE_INT_PATTERN = "[0-9]";
    private static final int NEGATIVE_BOUND = 0;

    private final int value;

    public PositiveInt(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException("0 미만의 숫자는 허용되지 않습니다.");
        }
        this.value = value;
    }

    public static PositiveInt from(final String value) {
        validateToParse(value);

        return new PositiveInt(parseInt(value));
    }

    private static void validateToParse(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }

        if (!Pattern.matches(POSITIVE_INT_PATTERN, value)) {
            throw new IllegalArgumentException("변환할 수 없는 문자가 포함되어 있습니다.");
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
