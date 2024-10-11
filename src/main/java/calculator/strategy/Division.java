package calculator.strategy;

public class Division implements OperationStrategy {
    private static final OperationStrategy INSTANCE = new Division();

    private Division() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(final int left, final int right) {
        return left / right;
    }
}
