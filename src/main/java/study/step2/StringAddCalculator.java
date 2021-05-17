package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n";
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        String customDelimiter = getCustomDelimiter(text);

        return text.replaceAll(CUSTOM_DELIMITER_REGEX, "").split(customDelimiter);
    }

    private static String getCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);

        if (m.find()) {
            return m.group(1);
        }

        return DEFAULT_DELIMITER_REGEX;
    }

    private static int sum(String ...number) {
        return Arrays.stream(number)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
