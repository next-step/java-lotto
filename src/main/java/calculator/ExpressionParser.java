package calculator;

public class ExpressionParser {
    public static NumberElements parse(String expression) {
        return new NumberElements(expression.split(":"));
    }
}
