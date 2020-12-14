package calculator.domain;

import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static calculator.domain.DelimiterType.*;

public class Expression {
    private static final int DELIMITER_INDEX_FOR_GROUP = 1;
    private static final int EXPRESSION_INDEX_FOR_GROUP = 2;

    private Operands operands;

    public Expression(String expression) {
        if (isEmpty(expression)) {
            this.operands = new Operands(new Operand());
            return;
        }
        initiateOperands(expression);
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }

    private void initiateOperands(String expression) {
        DelimiterType delimiterType = findByExpression(expression);
        if (delimiterType == CUSTOM) {
            initiateCustomOperands(expression);
            return;
        }
        initiateDefaultOperands(expression);
    }

    private void initiateDefaultOperands(String expression) {
        this.operands = convertOperands(expression.split(DEFAULT.getRegex()));
    }

    private void initiateCustomOperands(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        if (matcher.find()) {
            String delimiterGroup = matcher.group(DELIMITER_INDEX_FOR_GROUP);
            String[] expressionGroup = matcher.group(EXPRESSION_INDEX_FOR_GROUP).split(delimiterGroup);
            this.operands = convertOperands(expressionGroup);
        }
    }

    private Operands convertOperands(String[] expression) {
        return new Operands(
                Stream.of(expression)
                        .map(Operand::new)
                        .collect(Collectors.toList())
        );
    }

    public int sum() {
        return operands.sum();
    }
}
