package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public static final String ADDITIONAL_DELIMITER_REGEX = "//(.)\n(.*)";
    private Matcher additionalDelimiterMatcher;
    private String input;
    private Delimiters delimiters;

    public StringParser(String input) {
        this.input = input;
        additionalDelimiterMatcher = Pattern.compile(ADDITIONAL_DELIMITER_REGEX).matcher(input);
        delimiters = new Delimiters();
        parseAndReSetInput();
    }

    private boolean hasAdditionalDelimiter() {
        return additionalDelimiterMatcher.find();
    }

    private String parseAdditionalDelimiter() {
        return additionalDelimiterMatcher.group(1);
    }

    private String removedAdditionalDelimiterString() {
        return additionalDelimiterMatcher.group(2);
    }

    private void parseAndReSetInput() {
        if (hasAdditionalDelimiter()) {
            delimiters = delimiters.addDelimiter(parseAdditionalDelimiter());
            this.input = removedAdditionalDelimiterString();
        }
    }

    public List<String> parseByDelimiter() {
        return Arrays.asList(input.split(delimiters.getDelimitersRegexString()));
    }
}
