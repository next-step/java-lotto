package lotto;

import java.util.Objects;

public class Operand {
    private final int value;

    public Operand(int value) {
        if(value < 0) {
            throw new IllegalArgumentException(("negative numeric is not allowed. operand:" + value));
        }
        this.value = value;
    }

    public Operand add(Operand other) {
        return new Operand(value + other.value);
    }

    public int getValue() {
        return value;
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
        return Objects.hash(value);
    }
}
