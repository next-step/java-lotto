package domain;

public class DivideOperator implements Operator {
    private static final DivideOperator DIVIDE_OPERATOR = new DivideOperator();

    private DivideOperator() {
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }

    public static DivideOperator getDivideOperator() {
        return DIVIDE_OPERATOR;
    }
}
