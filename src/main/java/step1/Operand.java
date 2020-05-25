package step1;

import java.util.Objects;

public class Operand {

    public final static int ZERO_VALUE = 0;

    private final String operand;

    private Operand(String operand) {
        this.operand = operand;
    }

    public static Operand valueOf(String operand) {
        return new Operand(operand);
    }

    public int toInt() {
        return Integer.parseInt(this.operand);
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
