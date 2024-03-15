package lotto;

public class ExpressionSplitter {

    private static final String EXPRESSION_SEPARATOR_REGEX = " ";

    public Expression split(String stringExpression) {
        String[] expressionElements = stringExpression.split(EXPRESSION_SEPARATOR_REGEX);
        return new Expression(expressionElements);
    }
}
