package calculator;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Number {
    private final int value;

    public Number(String input) {
        this.value = parse(input);
    }

    private int parse(String input) {
        if (!StringUtils.isNumber(input)) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }

        int parsedInput = parseInt(input);

        if (parsedInput < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return parsedInput;
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
