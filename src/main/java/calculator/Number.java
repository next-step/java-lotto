package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number {
    private final int value;

    public Number(String input) {
        boolean matches = input.matches("[+-]?\\d*(\\.\\d+)?");

        if(!matches) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }

        int parsedInt = Integer.parseInt(input);

        if(parsedInt < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        this.value = parsedInt;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
