package stringcalculator;

import stringcalculator.command.Command;

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
            if (leftNumber == null) {
                return new ArithmeticExpression(Number.parse(value), this.command, this.rightNumber);
            } else if (rightNumber == null) {
                return new ArithmeticExpression(this.leftNumber, this.command, Number.parse(value));
            }
        } else {
            return new ArithmeticExpression(this.leftNumber, new CommandFactory().getCommand(value), this.rightNumber);
        }

        return this;
    }

    public ArithmeticExpression appendNumber(String value) {
        if (!Number.isNumber(value)) {
            return this;
        }

        if (leftNumber == null) {
            return new ArithmeticExpression(Number.parse(value), this.command, this.rightNumber);
        } else if (rightNumber == null) {
            return new ArithmeticExpression(this.leftNumber, this.command, Number.parse(value));
        } else {
            throw new RuntimeException();
        }
    }

    public ArithmeticExpression appendCommand(String value) {
        if (Number.isNumber(value)) {
            return this;
        }

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

}
