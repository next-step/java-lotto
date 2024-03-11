package calculator;

public class Expression {

    private final Operator operator;
    private final Operand left;
    private final Operand right;

    public Expression(Operator operator, Operand left, Operand right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public int calculate() {
        return operator.compute(left, right);
    }
}
