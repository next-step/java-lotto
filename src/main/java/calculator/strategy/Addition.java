package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;

public class Addition implements OperationStrategy {

    private static final OperationStrategy INSTANCE = new Addition();
    private static final Operator OPERATOR = new Operator("+");

    private Addition() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return OPERATOR.add(left, right);
    }
}
