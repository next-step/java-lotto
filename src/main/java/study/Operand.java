package study;

import java.util.Objects;

public class Operand {
    private int operand;

    public Operand(Integer operand) {
        if (Objects.isNull(operand)) {
            operand = 0;
        }
        if (operand < 0) {
            throw new IllegalArgumentException("0 이상의 수를 입력하여야 합니다.");
        }

        this.operand = operand;
    }

    public int getOperand() {
        return operand;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return operand == operand1.operand;
    }

    @Override public int hashCode() {
        return Objects.hash(operand);
    }
}
