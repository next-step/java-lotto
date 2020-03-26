package stringaccumulator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.emptyList;

public class Expressions {
    private static final Pattern DEFAULT_DELIMITERS = Pattern.compile(",|:");
    private static final Pattern CUSTOM_DELIMITERS = Pattern.compile("//(.)\n(.*)");
    private static final String NULL_STRING = "";
    private static final Operands EMPTY_LIST = new Operands(emptyList());

    private static final int CUSTOM_DELIMITER = 1;
    private static final int CUSTOM_EXPRESSION = 2;

    private Operands operands;

    public Expressions(String expression) {
        this.operands = separateExpression(expression);
    }

    public static Expressions of(String expression) {
        return new Expressions(expression);
    }

    public int sum() {
        return operands.sum();
    }

    private Operands separateExpression(String expression) {
        if (isNullOrEmpty(expression)) {
            return EMPTY_LIST;
        }
        return getOperandsByDelimiter(expression);
    }

    private Operands getOperandsByDelimiter(String expression) {
        Matcher matcher = CUSTOM_DELIMITERS.matcher(expression);
        if (matcher.find()) {
            return new Operands(
                    Arrays.asList(matcher.group(CUSTOM_EXPRESSION).split(matcher.group(CUSTOM_DELIMITER)))
            );
        }
        return new Operands(
                Arrays.asList(expression.split(DEFAULT_DELIMITERS.pattern()))
        );
    }

    private boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || Objects.equals(expression, NULL_STRING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expressions)) return false;
        Expressions that = (Expressions) o;
        return Objects.equals(operands, that.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }

}
