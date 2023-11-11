package step1.utils;

public class ExpressionSplitter {

    private static final String DEFAULT_DELIMITER = " ";

    public static String[] splitExpression(final String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }

}
