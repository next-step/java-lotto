package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    public static final Pattern EXPRESSION_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final Operands operands;

    private Expression(Operands operands) {
        this.operands = operands;
    }

    public static Expression of(String expression) {
        Matcher matcher = EXPRESSION_PATTERN.matcher(expression);
        if (matcher.find()) {
            Delimiter delimiter = Delimiter.from(matcher.group(1));
            Operands operands = Operands.from(Arrays.asList(delimiter.split(matcher.group(2))));
            return new Expression(operands);
        }

        return new Expression(Operands.from(Arrays.asList(Delimiter.DEFAULT_DELIMITER.split(expression))));
    }

    public int calculate() {
        return operands.sumOf();
    }
}
