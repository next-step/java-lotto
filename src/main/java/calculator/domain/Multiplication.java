package calculator.domain;

public class Multiplication implements Operator {

    public static final String MULTIPLICATION = "*";

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }

    @Override
    public boolean supports(String operator) {
        return MULTIPLICATION.equals(operator);
    }
}
