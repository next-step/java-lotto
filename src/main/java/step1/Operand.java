package step1;

import java.util.Objects;

public class Operand {
    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public Operand(String value) {
        this.value = Integer.parseInt(value);
    }

    private void validateOperand(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("잘못된 수식");
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
