package stringaccumulator;

import java.util.Objects;

public class Operand {
    private final String operand;

    public Operand(String operand) {
        this.operand = operand;
    }

    static int parseInt(Operand operand) {
        try {
            int intValue = Integer.parseInt(operand.getOperand());
            return isNegative(intValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }

    private static int isNegative(Integer operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return operand;
    }

    private String getOperand() {
        return operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operand)) return false;
        Operand operand1 = (Operand) o;
        return Objects.equals(operand, operand1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }

}
