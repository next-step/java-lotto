package calculator.domain;

public class DivideExpression implements CalculatorExpression {
    public VariableExpression calculate(VariableExpression dividend, VariableExpression divisor) {
        int result = Math.round((float)dividend.value() / divisor.value());
        return new VariableExpression(Character.forDigit(result, CalculatorExpression.RADIX));
    }
}
