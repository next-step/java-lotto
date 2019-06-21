package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern CUSTOM_PATTERN_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final String PREFIX_CUSTOM_HAS_DELIMITER = "//";
    static final String DEFAULT_DELIMITER = "[:,]";

    private String delimiter;
    private String tokens;

    private Expression(String delimiter, String tokens) {
        this.delimiter = delimiter;
        this.tokens = tokens;
    }

    public static Expression from(String inputOfString) {
        if (hasCustomDelimiter(inputOfString)) {
            Matcher customMatcher = CUSTOM_PATTERN_DELIMITER.matcher(inputOfString);
            if (customMatcher.find()) {
                return new Expression(customMatcher.group(1), customMatcher.group(2));
            }
        }
        return new Expression(DEFAULT_DELIMITER, inputOfString);
    }

    private static boolean hasCustomDelimiter(String inputOfString) {
        return inputOfString.startsWith(PREFIX_CUSTOM_HAS_DELIMITER);
    }

    String getDelimiter() {
        return delimiter;
    }

    String getTokens() {
        return tokens;
    }

    public Numbers numbers() {
        return Numbers.from(tokens.split(delimiter));
    }

}
