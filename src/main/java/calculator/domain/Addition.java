package calculator.domain;

public class Addition implements Operator {

    private static final String ADDITION = "+";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }

    @Override
    public boolean supports(String operator) {
        return ADDITION.equals(operator);
    }
}
