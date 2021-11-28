package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number {
    private final int value;

    public Number(String input) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        boolean matches = pattern.matcher(input).matches();

        if(!matches) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }

        int parsedInput = Integer.parseInt(input);

        if (parsedInput < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        this.value = parsedInput;
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
