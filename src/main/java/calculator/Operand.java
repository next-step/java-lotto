package calculator;

import java.util.Objects;

public class Operand {
    private final int value;
    public Operand(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("피연산자는 null이 될 수 없습니다");
        }

        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자가 숫자가 아닌 값이 입력되었습니다");
        }

    }

    public Operand(int value) {
        this.value = value;
    }

    public Operand add(Operand right) {
        return new Operand(value + right.value);
    }

    public Operand minus(Operand right) {
        return new Operand(value - right.value);
    }

    public Operand mul(Operand right) {
        return new Operand(value * right.value);
    }

    public Operand div(Operand right) {
        return new Operand(value / right.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
