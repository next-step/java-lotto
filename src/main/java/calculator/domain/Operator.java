package calculator.domain;

public class Operator {
    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    private final String operator;

    public Operator(String operator) {
        validate(operator);
        this.operator = operator;
    }

    private void validate(String operator) {
        if (operator.equals(ADDITION) || operator.equals(SUBTRACTION) || operator.equals(MULTIPLICATION) || operator.equals(DIVISION)) {
            return;
        }
        throw new IllegalArgumentException("지원하는 연산기호가 아닙니다.");
    }
}
