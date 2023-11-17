package calculator.domain;

public class Subtraction implements Operator{

    private static final String SUBTRACT = "-";

    public int operate(int first, int second) {
        return first - second;
    }

    public boolean supports(String operator) {
        return SUBTRACT.equals(operator);
    }
}
