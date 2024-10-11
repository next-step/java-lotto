package calculator.strategy;

public class Multiplication implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Multiplication();

    private Multiplication() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(final int left, final int right) {
        return left * right;
    }
}
