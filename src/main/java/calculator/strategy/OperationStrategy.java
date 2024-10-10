package calculator.strategy;

@FunctionalInterface
public interface OperationStrategy {
    int calculate(final int left, final int right);
}
