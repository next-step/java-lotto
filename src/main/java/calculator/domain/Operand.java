package calculator.domain;

public class Operand implements ExpressionElement {

    private final Number number;

    public Operand(String value) {
        this.number = new Number(value);
    }

    public Operand(int value) {
        this.number = new Number(value);
    }

    public int value() {
        return this.number.value();
    }
}
