package calculator;

public class Operator {

    private final String operator;

    public Operator(String input) {
        if(isNotOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operator = input;
    }

    private static boolean isNotOperator(String operator) {
        return !(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }

    public String value() {
        return operator;
    }
}
