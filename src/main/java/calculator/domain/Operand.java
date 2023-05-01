package calculator.domain;

public class Operand implements ExpressionElement {

    private final Number number;

    Operand(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("null로는 Operand를 생성할 수 없습니다.");
        }
        this.number = number;
    }

    public int value() {
        return this.number.value();
    }
}
