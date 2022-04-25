package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static stringcalculator.ExceptionCode.*;

public class Equation {
    private final static Pattern PATTERN = Pattern.compile("[0-9]+|[+-/*]");
    private final String input;

    public Equation(String input) {
        if (isNullOrBlank(input)) {
            throw new CalculatorException(INPUT_SHOULD_NOT_NULL_OR_BLANK);
        }

        boolean isWhitespaceNotExists = Arrays.stream(input.split(" "))
                        .anyMatch(this::isWhitespaceNotExists);

        if (isWhitespaceNotExists) {
            throw new CalculatorException(WHITESPACE_REQUIRED_BETWEEN_CHARACTER);
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
