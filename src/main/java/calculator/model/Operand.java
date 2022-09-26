package calculator.model;

import java.util.Objects;

public class Operand {

    private final int operand;

    public Operand(String operand) {
        try {
            this.operand = Integer.valueOf(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("operand must be integer", e);
        }
    }

    private Operand(int operand) {
        this.operand = operand;
    }

    public Operand plus(Operand input) {
        return new Operand(this.operand + input.operand);
    }

    public Operand minus(Operand input) {
        return new Operand(this.operand - input.operand);
    }

    public Operand multiply(Operand input) {
        return new Operand(this.operand * input.operand);
    }

    public Operand divide(Operand input) {
        return new Operand(this.operand / input.operand);
    }

    public int getOperand() {
        return operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return operand == operand1.operand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
