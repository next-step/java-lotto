package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Equation {
    private final static Pattern PATTERN = Pattern.compile("[0-9]+|[+-/*]");
    private final String input;

    public Equation(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_NOT_NULL_OR_BLANK.getMessage());
        }

        boolean isWhitespaceNotExists = Arrays.stream(input.split(" "))
                        .anyMatch(this::isWhitespaceNotExists);

        if (isWhitespaceNotExists) {
            throw new IllegalArgumentException(ExceptionMessage.WHITESPACE_REQUIRED_BETWEEN_CHARACTER.getMessage());
        }

        this.input = input;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private boolean isWhitespaceNotExists(String chars) {
        return !PATTERN.matcher(chars).matches();
    }

    public List<String> split(String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
