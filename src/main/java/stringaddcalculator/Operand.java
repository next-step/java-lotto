package stringaddcalculator;

import java.util.Objects;

public class Operand {
    private final int number;

    public Operand(int initialNumber) {
        verifyOperand(initialNumber);
        this.number = initialNumber;
    }

    public Operand(String initialNumber) {
        int number = Integer.parseInt(initialNumber);
        verifyOperand(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Operand add(Operand operand) {
        return new Operand(this.number + operand.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void verifyOperand(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("input은 음수가 될 수 없습니다.");
        }
    }
}
