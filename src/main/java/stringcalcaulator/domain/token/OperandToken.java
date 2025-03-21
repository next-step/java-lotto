package stringcalcaulator.domain.token;

import stringcalcaulator.domain.ExpressionTokenVisitor;

public class OperandToken implements ExpressionToken {

    private final int value;

    public OperandToken(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public OperandToken add(OperandToken operandToken) {
        return new OperandToken(this.value + operandToken.value);
    }

    public OperandToken sub(OperandToken operandToken) {
        return new OperandToken(this.value - operandToken.value);
    }

    public OperandToken mul(OperandToken operandToken) {
        return new OperandToken(this.value * operandToken.value);
    }

    public OperandToken div(OperandToken operandToken) {
        return new OperandToken(this.value / operandToken.value);
    }

    @Override
    public void accept(ExpressionTokenVisitor visitor) {
        visitor.visit(this);
    }
}
