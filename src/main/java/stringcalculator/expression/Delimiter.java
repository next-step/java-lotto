package stringcalculator.expression;

import stringcalculator.common.ExceptionMessage;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Delimiter {
    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private String delimiter;

    private Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter newInstance() {
        return new Delimiter(DEFAULT_DELIMITER_PATTERN);
    }

    public static Delimiter newInstance(String delimiter) {
        return new Delimiter(delimiter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }

    public ExpressionNumbers splitValue(String value) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_EXPRESSION.printMessage());
        }

        String[] values = value.split(this.delimiter);
        return ExpressionNumbers.newInstance(values);
    }
}
