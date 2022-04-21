package domain;

public class PlusOperator implements Operator {
    private static final PlusOperator PLUS_OPERATOR = new PlusOperator();

    private PlusOperator() {
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

    public static PlusOperator getPlusOperator() {
        return PLUS_OPERATOR;
    }
}
