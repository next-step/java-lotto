package calculator.domain;

import calculator.strategy.CalculationOrderStrategy;

public class StringCalculator {
    private final CalculationOrderStrategy calculationOrderStrategy;

    public StringCalculator(final CalculationOrderStrategy calculationOrderStrategy) {
        this.calculationOrderStrategy = calculationOrderStrategy;
    }

    public Operand calculate(final Strings strings) {
        return calculationOrderStrategy.calculate(strings);
    }
}
