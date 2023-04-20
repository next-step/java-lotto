package calculator.domain;

public class Operator {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    private final String operator;

    public Operator(String input) {
        if(isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if(isNotOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operator = input;
    }

    public String value() {
        return operator;
    }

    boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    boolean isNotOperator(String operator) {
        return !(operator.equals(PLUS) || operator.equals(MINUS) || operator.equals(MULTIPLY) || operator.equals(DIVIDE));
    }

    public boolean isPlus() {
        return operator.equals(PLUS);
    }

    public boolean isMinus() {
        return operator.equals(MINUS);
    }

    public boolean isMultiply() {
        return operator.equals(MULTIPLY);
    }

    public boolean isDivide() {
        return operator.equals(DIVIDE);
    }

}
