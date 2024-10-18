package calculator;

import calculator.expression.Expression;
import calculator.expression.NumberExpression;

public class Calculator {

    private final ExpressionParser expressionParser;

    public Calculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public int calc(String value) {
        Expression expression = expressionParser.parse(value);
        NumberExpression result = expression.calc();
        return result.value();
    }
}
