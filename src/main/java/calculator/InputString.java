package calculator;

import java.util.Objects;

public class InputString {
    private final String value;

    public InputString(String value) {
        checkString(value);
        this.value = value;
    }

    private static void checkString(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    public String[] parse(){
        return value.split(" ");
    }
}
