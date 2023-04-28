package calculator.domain;

public class OperationStrategyAdd implements OperationStrategy {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "+";
    }
}
