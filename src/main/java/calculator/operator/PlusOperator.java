package calculator.operator;

public class PlusOperator implements Operator {
    public static final String PLUS_EXPRESSION = "+";

    @Override
    public boolean match(String operator) {
        return PLUS_EXPRESSION.equals(operator);
    }

    @Override
    public long calculate(long sum, long operand) {
        return sum + operand;
    }
}
