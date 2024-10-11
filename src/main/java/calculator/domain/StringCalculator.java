package calculator.domain;

import calculator.strategy.CalculationOrderStrategy;

public class StringCalculator {
    private final CalculationOrderStrategy calculationOrderStrategy;

    public StringCalculator(final CalculationOrderStrategy calculationOrderStrategy) {
        this.calculationOrderStrategy = calculationOrderStrategy;
    }

    public int calculate(final String[] values) {
        return calculationOrderStrategy.calculate(values);
    }
}
