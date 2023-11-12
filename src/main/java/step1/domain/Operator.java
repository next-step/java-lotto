package step1.domain;

public class Operator {

    private String op;

    public Operator(String op) {
        validate(op);
        this.op = op;
    }

    private void validate(String op) {
        String fourOperators = "+-*/";
        if (!fourOperators.contains(op))
            throw new IllegalArgumentException();
    }

    public boolean isAdd() {
        return op.equals("+");
    }

    public boolean isSubtract() {
        return op.equals("-");
    }

    public boolean isMultiply() {
        return op.equals("*");
    }

    public boolean isDivide() {
        return op.equals("/");
    }
}
