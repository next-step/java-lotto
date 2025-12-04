package calculator;

import java.util.Arrays;
import java.util.List;

public class InputExpression {
    private final String value;

    InputExpression(String value) {
        validate(value);
        this.value = value.trim();
    }

    private void validate(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 null 또는 공백입니다.");
        }
    }

    List<String> splitBy(String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }
}
