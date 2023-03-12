package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String REGULAR_EXPRESSION = "\"//(.)\\n(.*)\"";
    public int add(final String text) {

        if (text == null || text.isEmpty()) { return 0; }

        return sum(getNumbers(text));
    }

    private String[] getNumbers(String text) {
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        } else {
            return text.split(",|:");
        }
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::parsePositiveNumber)
                .sum();
    }

    private int parsePositiveNumber(String text) {
        int value = Integer.parseInt(text);

        if (value >= 0) {
            return value;
        } else {
            throw new RuntimeException("양수만 입력 가능");
        }
    }
}
