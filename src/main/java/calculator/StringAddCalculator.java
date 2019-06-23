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
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private StringAddCalculator() {
    }

    public static int calculate(String text) {
        String[] tokens = split(text);

        int total = 0;
        for (String token : tokens) {
            Integer number = Integer.valueOf(token);

            ifNegativeNumberThrowException(number);

            total = total + number;
        }

        return total;
    }

    private static void ifNegativeNumberThrowException(Integer number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNegative(Integer number) {
        return number < 0;
    }

    private static  String[] split(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }
}
