package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    private String input;

    private DelimiterUtils(String input) {
        this.input = input;
    }

    public static DelimiterUtils create(String input) {
        return new DelimiterUtils(input);
    }

    public static boolean isEmpty(String input) {
        return false;
    }

    public static String findDelimiters(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (delimiterMatcher.find()) {
            return delimiterMatcher.group(1);
        }

        return DEFAULT_DELIMITER;
    }

    public boolean needDelimiterFinder() {
        return false;
    }

}
