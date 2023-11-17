package calculator.domain;

public class Addition implements Operator {

    private static final String ADD = "+";

    public int operate(int first, int second) {
        return first + second;
    }

    public boolean supports(String operator) {
        return ADD.equals(operator);
    }
}
