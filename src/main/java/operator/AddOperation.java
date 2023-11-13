package operator;

public class AddOperation implements Operation {
    private static final AddOperation instance = new AddOperation();

    private AddOperation() {
    }

    public static AddOperation instance() {
        return instance;
    }

    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
