package stringcalculator;

import java.util.Objects;

public class OperandInteger {

    public static final int ZERO = 0;

    private final int number;

    public OperandInteger() {
        this(ZERO);
    }

    public OperandInteger(String number) {
        this(Integer.parseInt(number));
    }

    public OperandInteger(int number) {
        if (number < ZERO) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public OperandInteger sum(OperandInteger other) {
        return new OperandInteger(this.number + other.number);
    }

    public int parseInputInteger() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperandInteger that = (OperandInteger) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
