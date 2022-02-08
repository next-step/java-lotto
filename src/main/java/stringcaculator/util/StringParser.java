package stringcaculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final int DELIMITER_POSITION = 1;
    private static final int REFINE_POSITION = 2;

    private StringParser() {}

    public static String[] splitDefaultDelimiter(String numbers) {
        return numbers.split(DEFAULT_DELIMITER);
    }

    public static String[] splitCustomDelimiter(String numbers) {
        Matcher matcher = CUSTOM_PATTERN.matcher(numbers);
        String customDelimiter = DEFAULT_DELIMITER;
        String refinedExpression = numbers;

        if (matcher.find()) {
            customDelimiter = matcher.group(DELIMITER_POSITION);
            refinedExpression = matcher.group(REFINE_POSITION);
        }

        return refinedExpression.split(customDelimiter);
    }
}
