package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DEFAULT_SPLITTER = ",:";
    private final static Pattern ADD_CUSTOM_SPLITTER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final static int REGEX_SPLITTER_GROUP = 1;
    private final static int REGEX_STRING_INPUT_GROUP = 2;
    private final static String ZERO_NUMBER = "0";

    private String splitter;
    private String targetString;

    private StringAddCalculator(String splitter, String targetString) {
        this.splitter = splitter;
        this.targetString = targetString;
    }

    public StringAddCalculator splitAndSum(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            return new StringAddCalculator(DEFAULT_SPLITTER, ZERO_NUMBER);
        }

        Matcher matcher = ADD_CUSTOM_SPLITTER_PATTERN.matcher(inputValue);

        if (matcher.find()) {
            String splitter = DEFAULT_SPLITTER + matcher.group(REGEX_SPLITTER_GROUP);
            return new StringAddCalculator(splitter, matcher.group(REGEX_STRING_INPUT_GROUP));
        }

        return new StringAddCalculator(DEFAULT_SPLITTER, inputValue);
    }

    public String getSplitter() {
        return splitter;
    }

    public String getTargetString() {
        return targetString;
    }

}
