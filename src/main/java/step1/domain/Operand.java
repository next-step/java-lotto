package step1.domain;

import step1.utils.TokenParser;

public class Operand {

    private int operandValue;

    private Operand(final int operandValue) {
        this.operandValue = operandValue;
    }

    public int getOperandValue() {
        return operandValue;
    }

    public static Operand of(final String token) {
        return new Operand(TokenParser.tokenParseInteger(token));
    }

    Operand plus(Operand rightOperand) {
        return new Operand(this.operandValue + rightOperand.operandValue);
    }

    Operand minus(Operand rightOperand) {
        return new Operand(this.operandValue - rightOperand.operandValue);
    }

    Operand multiple(Operand rightOperand) {
        return new Operand(this.operandValue * rightOperand.operandValue);
    }

    Operand divide(Operand rightOperand) {
        if (rightOperand.operandValue == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }

        return new Operand(this.operandValue / rightOperand.operandValue);
    }


}
