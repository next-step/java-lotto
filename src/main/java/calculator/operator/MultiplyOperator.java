package calculator.operator;

public class MultiplyOperator implements Operator {
    private static final MultiplyOperator multiplyOperator = new MultiplyOperator();

    private MultiplyOperator() {
    }

    public static Operator getOperator() {
        return multiplyOperator;
    }

    @Override
    public int operate(final int num1, final int num2) {
        return num1 * num2;
    }
}
