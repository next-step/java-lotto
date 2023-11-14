package step1.domain;

public class Operator {

    private static final String fourOperators = "+-*/";
    private String operator;

    public Operator(String operator) {
        validate(operator);
        this.operator = operator;
    }

    private void validate(String op) {
        if (!fourOperators.contains(op))
            throw new IllegalArgumentException();
    }

    public boolean isAdd() {
        return operator.equals("+");
    }

    public boolean isSubtract() {
        return operator.equals("-");
    }

    public boolean isMultiply() {
        return operator.equals("*");
    }

    public boolean isDivide() {
        return operator.equals("/");
    }
}
