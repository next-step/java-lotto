package stringcaculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String CUSTOM_PREFIX = "//";
    private static final String PATTERN_NOT_FOUND = "[ERROR] 커스텀 문자열을 찾을 수 없습니다.";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final int DELIMITER_POSITION = 1;
    private static final int REFINE_POSITION = 2;

    private StringParser() {
    }

    public static String[] splitExpression(String expression) {
        if (expression.startsWith(CUSTOM_PREFIX)) {
            return splitCustomDelimiter(expression);
        }
        return splitDefaultDelimiter(expression);
    }

    private static String[] splitDefaultDelimiter(String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }

    private static String[] splitCustomDelimiter(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        if (!matcher.find()) {
            throw new IllegalArgumentException(PATTERN_NOT_FOUND);
        }
        String customDelimiter = matcher.group(DELIMITER_POSITION);
        String refinedExpression = matcher.group(REFINE_POSITION);
        return refinedExpression.split(customDelimiter);
    }
}
