package calculator.domain;

public class Operand implements ExpressionElement {

    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public Operand(String value) {
        if (value == null) {
            throw new IllegalArgumentException("null은 Operand가 될 수 없습니다.");
        }
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return this.value;
    }

    public int calculate(Operator operator, Operand other) {
        if (operator == Operator.PLUS) {
            return plus(other);
        }
        if (operator == Operator.MINUS) {
            return minus(other);
        }
        if (operator == Operator.MULTIPLY) {
            return multiply(other);
        }
        if (operator == Operator.DIVIDE) {
            return divide(other);
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }

    private int plus(Operand other) {
        return this.value + other.value;
    }

    private int minus(Operand other) {
        return this.value - other.value;
    }

    private int multiply(Operand other) {
        return this.value * other.value;
    }

    private int divide(Operand other) {
        return this.value / other.value;
    }
}
