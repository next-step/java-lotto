package calculator.domain;

public class Division implements Operator {

    private static final String DIVISION = "/";

    public int operate(int first, int second) {
        validate(first, second);
        return first / second;
    }

    public boolean supports(String operator) {
        return DIVISION.equals(operator);
    }

    private static void validate(int first, int second) {
        if (first % second != 0) {
            throw new IllegalArgumentException();
        }
    }
}
