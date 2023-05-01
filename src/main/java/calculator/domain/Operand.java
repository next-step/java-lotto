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
        return this.number.value() + other.number.value();
    }

    private int minus(Operand other) {
        return this.number.value() - other.number.value();
    }

    private int multiply(Operand other) {
        return this.number.value() * other.number.value();
    }

    private int divide(Operand other) {
        return this.number.value() / other.number.value();
    }
}
