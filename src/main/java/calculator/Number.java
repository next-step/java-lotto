package calculator;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Number {
    private final int value;

    public Number(String input) {
        this(parseInt(input));
    }

    public Number(int input) {
        if (input < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        this.value = input;
    }

    public int getValue() {
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
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                '}';
    }
}
