package stringcaculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String PATTERN_NOT_FOUND = "[ERROR] 커스텀 문자열을 찾을 수 없습니다.";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final int DELIMITER_POSITION = 1;
    private static final int REFINE_POSITION = 2;

    private StringParser() {}

    public static String[] splitDefaultDelimiter(String numbers) {
        return numbers.split(DEFAULT_DELIMITER);
    }

    public static String[] splitCustomDelimiter(String numbers) {
        Matcher matcher = CUSTOM_PATTERN.matcher(numbers);
        if (!matcher.find()) {
            throw new IllegalArgumentException(PATTERN_NOT_FOUND);
        }
        String customDelimiter = matcher.group(DELIMITER_POSITION);
        String refinedExpression = matcher.group(REFINE_POSITION);
        return refinedExpression.split(customDelimiter);
    }
}
