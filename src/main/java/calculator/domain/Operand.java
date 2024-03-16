package calculator.domain;

import java.util.Objects;

public class Operand {
    private final int number;

    public Operand(int number) {
        this.number = number;
    }

    public Operand(String input) {
        this.number = toInt(input);
    }

    public int value() {
        return number;
    }

    private int toInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요.");
        }

        return number;
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
}
