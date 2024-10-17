package calculator;

public class DivisionOperator implements Operators {
    private static final String OPERATOR = "/";

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }

    @Override
    public boolean matchOperator(String operator) {
        return OPERATOR.equals(operator);
    }
}
