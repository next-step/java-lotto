package calculator;

public class ExpressionParser {
    public static NumberElementCollection parse(String expression) {
        return new NumberElementCollection(expression.split(":"));
    }
}
