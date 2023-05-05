package calculator.domain;

import java.util.Objects;

public class Operand {
    private final Double operand;

    public Operand(Double operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("operand는 음수를 가질 수 없습니다.");
        }
        this.operand = operand;
    }

    public Double getOperand() {
        return operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand1 = (Operand) o;
        return Objects.equals(operand, operand1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
