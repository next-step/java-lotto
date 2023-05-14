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

    public Operand(String operand) {
        this(parse(operand));
    }

    private static Double parse(String operand) {
        try {
            return Double.valueOf(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("operand에 숫자 포맷이 아닌 값이 입력되었습니다. input : " + operand);
        }
    }

    public Double getOperand() {
        return operand;
    }

    public Double plus(Operand value) {
        return operand + value.operand;
    }

    public Double minus(Operand value) {
        return operand - value.operand;
    }

    public Double multiple(Operand value) {
        return operand * value.operand;
    }

    public Double divide(Operand value) {
        return operand / value.operand;
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
