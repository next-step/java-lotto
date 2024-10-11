package calculator.strategy;

public class Subtraction implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Subtraction();

    private Subtraction() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(final int left, final int right) {
        return left - right;
    }
}
