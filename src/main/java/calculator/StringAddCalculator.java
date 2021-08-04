package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String PIPE = "|";
    public static final int DEFAULT_RESULT = 0;
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    public static int calculate(String input) {
        if (verify(input))
            return DEFAULT_RESULT;
        return getSum(split(input));
    }

    private static boolean verify(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        if (input.contains("-")) {
            throw new RuntimeException("음수가 포함되어 있습니다. input : " + input);
        }
        return false;
    }

    private static int getSum(String[] split) {
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }

    public static String[] split(String input) {
        Matcher matcher = getCustomDelimiterMatcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(getCustomDelimiter(matcher.group(1)));
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static Matcher getCustomDelimiterMatcher(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
    }

    private static String getCustomDelimiter(String delimiter) {
        return DEFAULT_DELIMITER + PIPE + delimiter;
    }
}
