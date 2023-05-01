package calculator.domain;

public class Operand implements ExpressionElement {

    private final Number number;

    public Operand(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("null 은 허용하지 않습니다.");
        }
        this.number = number;
    }

    public int value() {
        return this.number.value();
    }
}
