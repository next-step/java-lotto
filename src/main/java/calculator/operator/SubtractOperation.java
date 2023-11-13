package calculator.operator;

public class SubtractOperation implements Operation {
    private static final SubtractOperation instance = new SubtractOperation();

    private SubtractOperation() {

    }

    public static final SubtractOperation instance() {
        return instance;
    }

    @Override
    public int calculate(int first, int second) {
        return first - second;
    }
}
