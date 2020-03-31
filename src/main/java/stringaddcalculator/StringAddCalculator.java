package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String REGEX_PATTERN = "//(.)\n(.*)";

    public static final Pattern pattern = Pattern.compile(REGEX_PATTERN);

    public int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInt(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private int[] toInt(String[] values) {
        return Arrays.stream(values)
                .mapToInt(this::toPositive)
                .toArray();
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("입력에 음수가 포함될 수 없습니다.");
        }

        return number;
    }

    private String[] split(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
