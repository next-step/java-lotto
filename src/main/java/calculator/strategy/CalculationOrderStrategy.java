package calculator.strategy;

import calculator.domain.Strings;

@FunctionalInterface
public interface CalculationOrderStrategy {
    int calculate(final Strings strings);
}
