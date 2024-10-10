package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;

public class Subtraction implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Subtraction();
    private static final Operator OPERATOR = new Operator("*");

    private Subtraction() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return OPERATOR.subtract(left, right);
    }
}
