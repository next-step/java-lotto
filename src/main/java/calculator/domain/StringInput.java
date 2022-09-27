package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringInput {

    private static final String EMPTY_STRING = " ";

    private final String input;

    public StringInput(final String input) {

        validateNullOrEmpty(input);
        this.input = input;
    }

    private void validateNullOrEmpty(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    public List<String> split() {

        return Arrays.stream(this.input.split(EMPTY_STRING))
                .collect(Collectors.toList());
    }
}
