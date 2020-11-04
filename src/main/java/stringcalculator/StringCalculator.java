package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] inputSplits = input.split(getNumberDelimiterRegex());
        int result = 0;
        for (String inputSplit : inputSplits) {
            result += Integer.parseInt(inputSplit);
        }

        return result;
    }

    private String getNumberDelimiterRegex() {
        return "[" + String.join("", DEFAULT_DELIMITERS) + "]";
    }
}
