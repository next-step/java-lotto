package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wyparks2@gmail.com on 2019-06-20
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public final class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REX);
    private static final int ZERO = 0;

    private StringAddCalculator() {
    }

    public static int calculate(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int total = ZERO;
        for (String token : tokens) {
            Integer number = Integer.valueOf(token);

            ifNegativeNumberThrowException(number);

            total = total + number;
        }
        return total;
    }

    private static void ifNegativeNumberThrowException(Integer number) {
        if (isNegative(number)) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
    }

    private static boolean isNegative(Integer number) {
        return number < ZERO;
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }
}
