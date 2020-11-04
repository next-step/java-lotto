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

        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        if (hasCustomDelimiter(input)) {
            delimiters.add(String.valueOf(input.charAt(2)));
            input = input.substring(5);
        }

        String[] inputSplits = input.split(getNumberDelimiterRegex(delimiters));
        int result = 0;
        for (String inputSplit : inputSplits) {
            result += Integer.parseInt(inputSplit);
        }

        return result;
    }

    private boolean hasCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
    }

    private String getNumberDelimiterRegex(List<String> delimiters) {
        return "[" + String.join("", delimiters.toString()) + "]";
    }
}
