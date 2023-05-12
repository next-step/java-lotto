package calculator.calculator;

import calculator.parser.Expression;
import calculator.parser.ExpressionParser;

public class IntegerCalculator {
    private final ExpressionParser parser;

    public IntegerCalculator(ExpressionParser parser) {
        this.parser = parser;
    }

    public int calculate(String expressionString) {
        Expression expression = parser.parse(expressionString);

        Integer sum = expression.nextOperand();

        while (expression.hasOperator()) {
            String operator = expression.nextOperator();
            Integer number = expression.nextOperand();

            sum = IntegerOperation.valueOfOperator(operator)
                    .operate(sum, number);
        }

        return sum;
    }
}
