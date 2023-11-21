package calculator.operator;

public class MinusOperator implements Operator {

    public static final String MINUS_EXPRESSION = "-";

    @Override
    public boolean match(String operator) {
        return MINUS_EXPRESSION.equals(operator);
    }

    @Override
    public long calculate(long sum, long operand) {
        return sum - operand;
    }
}
