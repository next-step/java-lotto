package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_REGULAR_EXPRESSION = "//(.)\n(.*)";

    public List<String> parseInput(String userInput) {
        Matcher matcher = Pattern.compile(CUSTOM_REGULAR_EXPRESSION).matcher(userInput);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return Arrays.asList(userInput.split(DEFAULT_DELIMITER));
    }
}
