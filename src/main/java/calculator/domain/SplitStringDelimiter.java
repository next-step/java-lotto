package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitStringDelimiter {

    private static final String DEFAULT_PATTERN = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int PATTERN_GROUP_ONE = 1;
    private static final int PATTERN_GROUP_TWO = 2;

    public String[] splitString(String inputValue) {

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(inputValue);

        if (m.find()) {
            String customDelimiter = m.group(PATTERN_GROUP_ONE);
            return m.group(PATTERN_GROUP_TWO).split(customDelimiter);

        }
        return inputValue.split(DEFAULT_PATTERN);
    }
}
