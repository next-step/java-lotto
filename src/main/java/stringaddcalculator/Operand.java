package stringaddcalculator;

import java.util.Objects;

public class Operand {
    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public static Operand from(String s) {
        int intValue = Integer.parseInt(s);
        if (intValue < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return new Operand(intValue);
    }

    public static Operand zero() {
        return new Operand(0);
    }

    public int getValue() {
        return value;
    }

    public Operand plus(Operand other) {
        return new Operand(value + other.value);
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
