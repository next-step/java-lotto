package calculator.domain;

public class OperationStrategyAdd implements OperationStrategy {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return Operation.ADD;
    }

    @Override
    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
