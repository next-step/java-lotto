package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;

public class Multiplication implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Multiplication();
    private static final Operator OPERATOR = new Operator("*");

    private Multiplication() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return OPERATOR.multiply(left, right);
    }
}
