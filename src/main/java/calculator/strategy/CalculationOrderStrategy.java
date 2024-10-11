package calculator.strategy;

@FunctionalInterface
public interface CalculationOrderStrategy {
    int calculate(final String[] values);
}
