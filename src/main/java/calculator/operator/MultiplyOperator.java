package calculator.operator;

public class MultiplyOperator implements Operator {

    public static final String MULTIPLY_EXPRESSION = "*";

    @Override
    public boolean match(String operator) {
        return MULTIPLY_EXPRESSION.equals(operator);
    }

    @Override
    public long calculate(long sum, long operand) {
        return sum * operand;
    }
}
