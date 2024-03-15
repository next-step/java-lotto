package lotto;

import lotto.exception.IllegalExpressionElementSizeException;

public class ExpressionSplitter {

    private static final String EXPRESSION_SEPARATOR_REGEX = " ";

    public Expression split(String stringExpression) throws IllegalExpressionElementSizeException {
        String[] expressionElements = stringExpression.split(EXPRESSION_SEPARATOR_REGEX);
        ExpressionValidator.validateElementSize(expressionElements.length);
        return new Expression(expressionElements);
    }
}
