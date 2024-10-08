package calculator.strategy;

import calculator.domain.Operand;
import calculator.domain.Strings;

@FunctionalInterface
public interface CalculationOrderStrategy {
    Operand calculate(final Strings strings);
}
