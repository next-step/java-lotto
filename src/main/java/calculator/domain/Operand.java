package calculator.domain;

import java.util.Objects;

public class Operand {
    private static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수가 아닙니다.";
    private final int value;

    private Operand(int value) {
        this.value = value;
    }

    public static Operand valueOf(int value) {
        return new Operand(value);
    }

    public static Operand valueOf(String value) {
        try {
            int intValue = Integer.parseInt(value);
            return new Operand(intValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
        }
    }

    public int value() {
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
