package stringcalculator.domain.operator;

public class Subtraction implements Operator {

    private static final String MINUS = "-";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 - operand2;
    }

    @Override
    public boolean supports(String operator) {
        return MINUS.equals(operator);
    }
}
