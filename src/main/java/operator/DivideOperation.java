package operator;

public class DivideOperation implements Operation {

    private static final DivideOperation instance = new DivideOperation();

    private DivideOperation() {
    }

    public static DivideOperation instance() {
        return instance;
    }

    @Override
    public int calculate(int first, int second) {
        return first / second;
    }
}
