package calculator;

public class CalculatedExpression extends Operand {

    public CalculatedExpression(Expression left, Operator operator, Operand right) {
        this(CalculatedExpression.from(left), operator, right);
    }

    public CalculatedExpression(Operand left, Operator operator, Operand right) {
        super(operator.compute(left, right));
    }

    public static Operand from(Expression expression) {
        if (expression.isSingleToken()) {
            return expression.firstOperand();
        }
        return new CalculatedExpression(
            expression.expressionWithoutLastOperatorAndOperand(),
            expression.lastOperator(),
            expression.lastOperand()
        );
    }

    public int value() {
        return super.value();
    }
}
