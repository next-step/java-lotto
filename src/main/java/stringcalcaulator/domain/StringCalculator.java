package stringcalcaulator.domain;

public class StringCalculator {

    public int calculate(String expressionStr) {
        ExpressionIterator iterator = new ExpressionIterator(expressionStr);
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parse(iterator);
        ExpressionCalculator visitor = new ExpressionCalculator();
        return expression.accept(visitor);
    }

}
