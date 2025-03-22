package stringcalcaulator.domain;

public class OperandExpression implements Expression {

    private final int value;

    public OperandExpression(String token) {
        this.value = Integer.parseInt(token);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int accept(ExpressionCalculator visitor) {
        return visitor.visit(this);
    }
}
