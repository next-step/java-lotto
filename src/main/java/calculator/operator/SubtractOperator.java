package calculator.operator;

public class SubtractOperator implements Operator {
    private static final SubtractOperator subtractOperator = new SubtractOperator();

    private SubtractOperator() {
    }

    public static Operator getOperator() {
        return subtractOperator;
    }

    @Override
    public int operate(final int num1, final int num2) {
        return num1 - num2;
    }
}
