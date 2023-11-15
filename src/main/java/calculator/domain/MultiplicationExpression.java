package calculator.domain;

public class MultiplicationExpression implements CalculatorExpression {

    public VariableExpression calculate(VariableExpression left, VariableExpression right) {
        int result = left.value() * right.value();
        return new VariableExpression(Character.forDigit(result, CalculatorExpression.RADIX));
    }
}
