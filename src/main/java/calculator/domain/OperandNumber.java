package calculator.domain;

import java.util.Objects;

public class OperandNumber {
    private final Integer operand;

    public OperandNumber(String number) {
        this(Integer.valueOf(number));
    }
    public OperandNumber(Integer number) {
        this.operand = number;
    }

    public OperandNumber plus(OperandNumber second) {
        return new OperandNumber(this.operand + second.operand);
    }
    public OperandNumber minus(OperandNumber second) {
        return new OperandNumber(this.operand - second.operand);
    }

    public OperandNumber multiply(OperandNumber second) {
        return new OperandNumber(this.operand * second.operand);
    }

    public OperandNumber divide(OperandNumber second) {
        return new OperandNumber(this.operand / second.operand);
    }

    public Integer getValue() {
        return this.operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperandNumber that = (OperandNumber) o;
        return operand.equals(that.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
