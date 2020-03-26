package stringaccumulator;

import java.util.Objects;

import static stringaccumulator.Constant.ONLY_NUMBER;
import static stringaccumulator.Constant.ONLY_POSITIVE;

public class Operand {
    private static final int ZERO = 0;

    private final String operand;

    Operand(String operand) {
        this.operand = operand;
    }

    static int parseInt(Operand operand) {
        try {
            int intValue = Integer.parseInt(operand.getOperand());
            return isNegative(intValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private static int isNegative(Integer operand) {
        if (operand < ZERO) {
            throw new IllegalArgumentException(ONLY_POSITIVE);
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
