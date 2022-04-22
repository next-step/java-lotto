package string_calculator;

import java.util.Objects;

public class Integer implements Value  {
    private final int value;

    public Integer(int i) {
        this.value = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integer integer = (Integer) o;
        return value == integer.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Integer plus(Integer operand) {
        return new Integer(this.value + operand.value);
    }

    public Integer minus(Integer operand) {
        return new Integer(this.value - operand.value);
    }

    public Integer multiply(Integer operand) {
        return new Integer(this.value * operand.value);
    }

    public Integer divide(Integer operand) {
        return new Integer(this.value / operand.value);
    }

    public Integer modulo(Integer operand) {
        return new Integer(this.value % operand.value);
    }

    public void print(Integer payload) {
        System.out.printf("Result: %d\n", payload.value);
    }
}
