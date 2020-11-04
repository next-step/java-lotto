package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final List<String> DEFAULT_DELIMITERS = new ArrayList<>(Arrays.asList(",", ":"));
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//.\\\\n.*");
    public static final int INDEX_OF_CUSTOM_DELIMITER = 2;
    public static final int LAST_INDEX_OF_CUSTOM_DELIMITER_PHRASE = 5;

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        if (hasCustomDelimiter(input)) {
            delimiters.add(String.valueOf(input.charAt(INDEX_OF_CUSTOM_DELIMITER)));
            input = input.substring(LAST_INDEX_OF_CUSTOM_DELIMITER_PHRASE);
        }

        String[] inputSplits = input.split(getNumberDelimiterRegex(delimiters));
        int result = 0;
        for (String inputSplit : inputSplits) {
            int number = Integer.parseInt(inputSplit);

            if (number < 0) {
                throw new RuntimeException();
            }

            result += number;
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
