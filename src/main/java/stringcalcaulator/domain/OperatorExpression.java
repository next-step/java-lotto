package stringcalcaulator.domain;

public class OperatorExpression implements Expression {
    private final Expression left;
    private final Operator operator;
    private final Expression right;

    public OperatorExpression(Expression left, Operator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public int calculate(int left, int right) {
        return operator.calculate(left, right);
    }

    @Override
    public int accept(ExpressionCalculator visitor) {
        return visitor.visit(this);
    }
}
