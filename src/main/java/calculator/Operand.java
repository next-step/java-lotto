package calculator;

import java.util.Objects;

public class Operand {

    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public static Operand from(String token) {
        return new Operand(tryParseInt(token));
    }

    private static int tryParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("피연산자 자리에는 숫자만 올 수 있습니다");
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

    @Override
    public String toString() {
        return "Operand{" +
            "value=" + value +
            '}';
    }
}
