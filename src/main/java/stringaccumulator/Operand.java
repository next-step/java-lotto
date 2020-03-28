package stringaccumulator;

import java.util.Objects;

public class Operand {
    private static final int ZERO = 0;

    private final String operand;

    Operand(String operand) {
        this.operand = operand;
    }

    static int parseInt(Operand operand) {
        try {
            int intValue = Integer.parseInt(operand.getOperand());
            return parsePositive(intValue);
        } catch (NumberFormatException e) {
            throw new OnlyNumberViolationException();
        }
    }

    private static int parsePositive(Integer operand) {
        if (operand < ZERO) {
            throw new OnlyPositiveViolationException();
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
