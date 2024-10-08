package calculator.strategy;

import calculator.domain.Operand;

public class Division implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Division();

    private Division() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return left.divide(right);
    }
}
