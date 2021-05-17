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
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String number) {
        try {
            Integer num = Integer.parseInt(number);

            return parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자를 제외한 텍스트는 숫자형식만 가능합니다.");
        }
    }

    private static int parseInt(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수 값 덧셈은 지원하지 않습니다.");
        }

        return num;
    }
}
