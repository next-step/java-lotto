package calculator;

import java.util.Objects;

public class Operand extends Token {

    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public static Operand of(Token token) {
        if (!(token instanceof Operand)) {
            throw new IllegalArgumentException("연산자 또는 피연산자가 잘못된 위치에 있음");
        }
        return (Operand) token;
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

    @Override
    public String toString() {
        return "Operand{" +
            "value=" + value +
            '}';
    }
}
