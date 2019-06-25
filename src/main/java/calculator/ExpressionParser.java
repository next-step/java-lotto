package calculator;

public class ExpressionParser {

    public static NumberElementCollection parse(String expression) {

        ExpressionSplitter expressionSplitter = new ExpressionSplitter(expression);
        String[] elements = expressionSplitter.split();

        return new NumberElementCollection(elements);
    }
}
