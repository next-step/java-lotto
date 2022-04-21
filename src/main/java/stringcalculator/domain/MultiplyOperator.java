package stringcalculator.domain;

public class MultiplyOperator implements Operator {
    private static final MultiplyOperator MULTIPLY_OPERATOR = new MultiplyOperator();

    private MultiplyOperator() {
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }

    public static MultiplyOperator getMultiplyOperator() {
        return MULTIPLY_OPERATOR;
    }
}
