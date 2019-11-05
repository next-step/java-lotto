package calc;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    private static final String DEFAULT_INPUT_DELIMITER = ",|:";
    private static final String CUSTOM_INPUT_DELIMITER_START = "//";
    private static final String CUSTOM_INPUT_DELIMITER_END = "\n";
    private static final Pattern INPUT_DELIMITER_PATTERN = Pattern
        .compile(CUSTOM_INPUT_DELIMITER_START + "(.)" + CUSTOM_INPUT_DELIMITER_END + "(.*)");
    private final Numbers numbers;

    public InputChecker(String input) {
        this.numbers = checkInput(input);
    }

    private Numbers checkInput(String input) {
        if (Objects.isNull(input) || input.equals("")) {
            return new Numbers(Arrays.asList(0));
        }

        Matcher inputMatcher = INPUT_DELIMITER_PATTERN.matcher(input);
        if (inputMatcher.find()) {
            String customDelimiter = inputMatcher.group(1);
            return convertInputWithDelimeter(inputMatcher.group(2), customDelimiter);
        }

        return convertInputWithDelimeter(input, DEFAULT_INPUT_DELIMITER);
    }

    private Numbers convertInputWithDelimeter(String input,
        String delimeter) {
        return new Numbers(input.split(delimeter));
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
