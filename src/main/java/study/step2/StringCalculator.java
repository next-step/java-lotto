package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final static String CUSTOM_DELIMITER_REGEX = "^//(.)\n";
    private final static String DEFAULT_DELIMITER_REGEX = "[,:]";

    private Pattern customPattern;

    public StringCalculator() {
        customPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    }

    public int sum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);
        return sum(tokens);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        String customDelimiter = getCustomDelimiter(text);

        return text.replaceAll(CUSTOM_DELIMITER_REGEX, "").split(customDelimiter);
    }

    private String getCustomDelimiter(String text) {
        final int firstMatchIndex = 1;

        Matcher matcher = customPattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(firstMatchIndex);
        }

        return DEFAULT_DELIMITER_REGEX;
    }

    private int sum(String ...num) {
        return Arrays.stream(num)
                .mapToInt(this::parseInt)
                .sum();
    }

    private int parseInt(String num) {
        try {
            int number = Integer.parseInt(num);

            return parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자를 제외한 텍스트는 숫자형식만 가능합니다.");
        }
    }

    private int parseInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값 덧셈은 지원하지 않습니다.");
        }

        return number;
    }
}
