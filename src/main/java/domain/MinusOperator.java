package domain;

public class MinusOperator implements Operator {
    private static final MinusOperator MINUS_OPERATOR = new MinusOperator();

    private MinusOperator() {
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }

    public static MinusOperator getMinusOperator() {
        return MINUS_OPERATOR;
    }
}
