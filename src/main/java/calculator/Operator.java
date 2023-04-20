package calculator;

public class Operator {

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
        return !(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }
}
