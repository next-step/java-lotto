package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtils {

    private static final String REGEX_DELIMITER_DEFAULT = "[,:]";
    private static final Pattern REGEX_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    private static final int MATCHER_DELIMITER_GROUP = 1;
    private static final int MATCHER_EXPRESSION_GROUP = 2;

    private static final String MESSAGE_UTILITY_CLASS = "Utility class";

    private SplitUtils() {
        throw new IllegalStateException(MESSAGE_UTILITY_CLASS);
    }

    public static String[] split(String input) {
        Matcher matcher = REGEX_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            return split(matcher.group(MATCHER_DELIMITER_GROUP), matcher.group(MATCHER_EXPRESSION_GROUP));
        }
        return split(REGEX_DELIMITER_DEFAULT, input);
    }

    private static String[] split(String delimiter, String expression) {
        return expression.split(delimiter);
    }
}
