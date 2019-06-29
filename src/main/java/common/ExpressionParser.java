package common;

public class ExpressionParser {

    public static NumberCollection parse(String expression) {

        ExpressionSplitter expressionSplitter = new ExpressionSplitter(expression);
        String[] elements = expressionSplitter.split();

        return new NumberCollection(elements);
    }
}
