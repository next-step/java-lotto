package calculator.operator;

public class DivideOperator implements Operator {
    private static final DivideOperator divideOperator = new DivideOperator();

    private DivideOperator() {
    }

    public static Operator getOperator() {
        return divideOperator;
    }

    @Override
    public int operate(final int num1, final int num2) {
        return num1 / num2;
    }
}
