package calculator.domain;

public class Subtraction implements Operator {

    public static final String SUBTRACTION = "-";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 - operand2;
    }

    @Override
    public boolean supports(String operator) {
        return SUBTRACTION.equals(operator);
    }
}
