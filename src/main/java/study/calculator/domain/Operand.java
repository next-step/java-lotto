package study.calculator.domain;

import java.util.Objects;

public class Operand {
    private static final int ZERO = 0;
    private int operand;

    private Operand(int operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("0 이상의 수를 입력하여야 합니다.");
        }

        this.operand = operand;
    }

    public static Operand getInstance(String operand) {
        if (Objects.isNull(operand) || operand.isEmpty()) {
            return new Operand(ZERO);
        }
        
        return new Operand(Integer.parseInt(operand));
    }

    public static Operand getInstance(int operand) {
        return new Operand(operand);
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
