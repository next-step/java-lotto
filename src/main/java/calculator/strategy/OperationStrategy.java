package calculator.strategy;

import calculator.domain.Operand;

@FunctionalInterface
public interface OperationStrategy {
    Operand calculate(final Operand left, final Operand right);
}
