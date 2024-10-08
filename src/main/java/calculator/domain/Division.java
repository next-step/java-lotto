package calculator.domain;

public class Division implements Operator {

    public static final String DIVISION = "/";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 / operand2;
    }

    @Override
    public boolean supports(String operator) {
        return DIVISION.equals(operator);
    }
}
