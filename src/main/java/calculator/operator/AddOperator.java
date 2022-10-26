package calculator.operator;

public class AddOperator implements Operator {
    private static final AddOperator addOperator = new AddOperator();

    private AddOperator() {
    }

    public static Operator getOperator() {
        return addOperator;
    }

    @Override
    public int operate(final int num1, final int num2) {
        return num1 + num2;
    }
}
