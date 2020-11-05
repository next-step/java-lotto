package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

class StringParser {
    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//.\\\\n.*");
    private static final int INDEX_OF_CUSTOM_DELIMITER = 2;
    private static final int LAST_INDEX_OF_CUSTOM_DELIMITER_PHRASE = 5;

    List<Integer> getNumbersFrom(String input) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        if (hasCustomDelimiter(input)) {
            input = processCustomDelimiter(input, delimiters);
        }

        return parseStringToNumber(input, delimiters);
    }

    private boolean hasCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
    }

    private String processCustomDelimiter(String input, List<String> delimiters) {
        delimiters.add(String.valueOf(input.charAt(INDEX_OF_CUSTOM_DELIMITER)));
        input = input.substring(LAST_INDEX_OF_CUSTOM_DELIMITER_PHRASE);
        return input;
    }

    private List<Integer> parseStringToNumber(String input, List<String> delimiters) {
        String[] inputSplits = input.split(getNumberDelimiterRegex(delimiters));
        List<Integer> integers = new ArrayList<>();
        for (String inputSplit : inputSplits) {
            integers.add(Integer.parseInt(inputSplit));
        }
        return Collections.unmodifiableList(integers);
    }

    private String getNumberDelimiterRegex(List<String> delimiters) {
        return "[" + String.join("", delimiters) + "]";
    }
}
