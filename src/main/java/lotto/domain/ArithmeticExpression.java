package lotto.domain;

import lotto.command.Command;
import lotto.command.CommandFactory;

public class ArithmeticExpression {
    private final Number leftNumber;
    private final Command command;
    private final Number rightNumber;

    public ArithmeticExpression() {
        this(null, null, null);
    }

    public ArithmeticExpression(Number leftNumber) {
        this(leftNumber, null, null);
    }

    public ArithmeticExpression(Number leftNumber, Command command, Number rightNumber) {
        this.leftNumber = leftNumber;
        this.command = command;
        this.rightNumber = rightNumber;
    }

    public ArithmeticExpression append(String value) {
        if (Number.isNumber(value)) {
            return appendNumber(value);
        } else {
            return appendCommand(value);
        }
    }

    private ArithmeticExpression appendNumber(String value) {
        if (leftNumber != null && rightNumber != null) {
            throw new RuntimeException("계산 중 오류가 발생했습니다. 계산식=" + this.toString());
        }

        if (leftNumber == null) {
            return new ArithmeticExpression(Number.parse(value), this.command, this.rightNumber);
        } else {
            return new ArithmeticExpression(this.leftNumber, this.command, Number.parse(value));
        }
    }

    private ArithmeticExpression appendLeftNumber(String value) {
        return new ArithmeticExpression(Number.parse(value), this.command, this.rightNumber);
    }

    private ArithmeticExpression appendCommand(String value) {
        return new ArithmeticExpression(this.leftNumber, new CommandFactory().getCommand(value), this.rightNumber);
    }

    public boolean complete() {
        return this.leftNumber != null && this.command != null && this.rightNumber != null;
    }

    public ArithmeticExpression evaluate() {
        return new ArithmeticExpression(this.command.execute(this.leftNumber, this.rightNumber));
    }

    public Number getResult() {
        return this.leftNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArithmeticExpression{");
        sb.append("leftNumber=").append(leftNumber);
        sb.append(", command=").append(command);
        sb.append(", rightNumber=").append(rightNumber);
        sb.append('}');
        return sb.toString();
    }
}
