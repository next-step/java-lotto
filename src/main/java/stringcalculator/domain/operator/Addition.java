package stringcalculator.domain.operator;

public class Addition implements Operator {

    private static final String PLUS = "+";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }

    @Override
    public boolean supports(String operator) {
        return PLUS.equals(operator);
    }
}
