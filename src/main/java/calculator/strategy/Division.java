package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;

public class Division implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Division();
    private static final Operator OPERATOR = new Operator("/");

    private Division() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public Operand calculate(final Operand left, final Operand right) {
        return OPERATOR.divide(left, right);
    }
}
