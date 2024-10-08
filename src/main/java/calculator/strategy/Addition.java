package calculator.strategy;

import calculator.domain.Operand;

public class Addition implements OperationStrategy {

    private static final OperationStrategy INSTANCE = new Addition();

    private Addition() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return left.add(right);
    }
}
