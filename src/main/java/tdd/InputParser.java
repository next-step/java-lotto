package tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = ",|:|%s";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    static String [] parseToNumberTexts(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        String delimiter = DEFAULT_DELIMITER;
        String text = input;

        if (matcher.find()) {
            delimiter = String.format(CUSTOM_DELIMITER, matcher.group(1));
            text = matcher.group(2);
        }

        return text.split(delimiter);
    }
}
