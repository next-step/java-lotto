package stringaccumulator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class Expressions {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITERS = Pattern.compile("//(.)\n(.*)");
    private static final String NULL_STRING = "";
    private static final Operands EMPTY_LIST = new Operands(emptyList());

    private static final int EXTRACTED_DELIMITER = 1;
    private static final int EXTRACTED_EXPRESSION = 2;

    private final Operands operands;

    private Expressions(String expression) {
        this.operands = separateExpression(expression);
    }

    static Expressions of(String expression) {
        return new Expressions(expression);
    }

    int sum() {
        return operands.sum();
    }

    private Operands separateExpression(String expression) {
        if (isNullOrEmpty(expression)) {
            return EMPTY_LIST;
        }
        return getOperandsByDelimiter(expression);
    }

    private boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || Objects.equals(expression, NULL_STRING);
    }

    private Operands getOperandsByDelimiter(String expression) {
        Matcher matcher = CUSTOM_DELIMITERS.matcher(expression);
        if (matcher.find()) {
            return new Operands(
                    asList(matcher.group(EXTRACTED_EXPRESSION).split(matcher.group(EXTRACTED_DELIMITER)))
            );
        }
        return new Operands(
                asList(expression.split(DEFAULT_DELIMITERS))
        );
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
