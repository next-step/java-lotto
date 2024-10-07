package stringcalculator.domain.operator;

public class Multiplication implements Operator {

    private static final String MULTIPLY = "*";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }

    @Override
    public boolean supports(String operator) {
        return MULTIPLY.equals(operator);
    }
}
