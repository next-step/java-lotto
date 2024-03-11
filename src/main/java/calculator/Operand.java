package calculator;

import java.util.Objects;

public class Operand {

    private final int value;

    public Operand(String value) {
        this(tryParseInt(value));
    }

    public Operand(int value) {
        this.value = value;
    }

    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Operand에는 정수만 올 수 있음");
        }
    }

    public int value() {
        return value;
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

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
