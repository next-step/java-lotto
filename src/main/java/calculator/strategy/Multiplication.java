package calculator.strategy;

import calculator.domain.Operand;

public class Multiplication implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Multiplication();

    private Multiplication() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return left.multiply(right);
    }
}
