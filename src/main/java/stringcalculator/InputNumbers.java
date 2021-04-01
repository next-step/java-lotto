package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputNumbers {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;
    private static final String ZERO = "0";

    private final String input;

    public InputNumbers(String input) {
        this.input = validate(input);
    }

    private String validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            input = ZERO;
        }
        return input;
    }

    public String[] numbers() {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(NUMBERS_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumbers inputNumbers = (InputNumbers) o;
        return Objects.equals(input, inputNumbers.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
