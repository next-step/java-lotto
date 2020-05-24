package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String EXCEPTION_RETURN_VALUE = "0";
    private static final String CUSTOM_REGULAR_EXPRESSION = "//(.)\n(.*)";
    private static final int DELIMITER_INDEX = 1;
    private static final int EXPRESSION_INDEX = 2;

    private StringSplitter() {
    }

    public static String[] splitString(String userInput) {
        if (validateNullOrEmpty(userInput) == true)
            return new String[]{EXCEPTION_RETURN_VALUE};
        Matcher matcher = Pattern.compile(CUSTOM_REGULAR_EXPRESSION).matcher(userInput);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_INDEX);
            return matcher.group(EXPRESSION_INDEX).split(customDelimiter);
        }
        return userInput.split(DEFAULT_DELIMITER);
    }

    private static boolean validateNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }
}
