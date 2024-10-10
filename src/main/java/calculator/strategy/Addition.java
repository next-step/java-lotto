package calculator.strategy;

public class Addition implements OperationStrategy {

    private static final OperationStrategy INSTANCE = new Addition();

    private Addition() {
    }

    public static OperationStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(final int left, final int right) {
        return left + right;
    }
}
