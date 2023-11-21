package calculator.operator;

public class DivideOperator implements Operator {

    public static final String DIVIDE_EXPRESSION = "/";

    @Override
    public boolean match(String operator) {
        return DIVIDE_EXPRESSION.equals(operator);
    }

    @Override
    public long calculate(long sum, long operand) {
        return sum / operand;
    }
}
