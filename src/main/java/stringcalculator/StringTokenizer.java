package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTokenizer {

    private static final String REGULAR_EXPRESSION = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int TOKENS = 2;
    private static final String DELIMITER = ",|:";

    public static String[] splitString(String input) {
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER);
            return matcher.group(TOKENS).split(customDelimiter);
        }

        return input.split(DELIMITER);
    }
}
