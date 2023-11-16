package calculator.operator;

public class MultiplyOperation implements Operation {
    private static final MultiplyOperation instance = new MultiplyOperation();

    private MultiplyOperation() {
    }

    public static MultiplyOperation instance() {
        return instance;
    }

    @Override
    public int calculate(int first, int second) {
        return first * second;
    }
}
