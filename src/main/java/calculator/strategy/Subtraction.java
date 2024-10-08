package calculator.strategy;

import calculator.domain.Operand;

public class Subtraction implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Subtraction();

    private Subtraction() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return left.subtract(right);
    }
}
