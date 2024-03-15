package lotto.util;

import lotto.exception.IllegalExpressionElementSizeException;

public class ExpressionSplitter {

    private static final String EXPRESSION_SEPARATOR_REGEX = " ";

    public static String[] split(String stringExpression) throws IllegalExpressionElementSizeException {
        return stringExpression.split(EXPRESSION_SEPARATOR_REGEX);
    }
}
