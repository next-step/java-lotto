package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final List<String> DEFAULT_DELIMITERS = new ArrayList<>(Arrays.asList(",", ":"));
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//.\\\\n.*");

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (hasCustomDelimiter(input)) {
            addDelimiter();
            input = input.substring(5);
        }

        String[] inputSplits = input.split(getNumberDelimiterRegex());
        int result = 0;
        for (String inputSplit : inputSplits) {
            result += Integer.parseInt(inputSplit);
        }

        return result;
    }

    private void addDelimiter() {
        DEFAULT_DELIMITERS.add(";");
    }

    private boolean hasCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
    }

    private String getNumberDelimiterRegex() {
        return "[" + String.join("", DEFAULT_DELIMITERS) + "]";
    }
}
