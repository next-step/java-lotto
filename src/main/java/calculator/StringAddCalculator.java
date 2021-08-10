package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String MESSAGE = "음수는 더할 수 없습니다.";
    private static final String SEPARATOR = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] numbers = divideString(text);
        return sumNumbers(numbers);
    }

    public static String[] divideString(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(SEPARATOR);
    }

    public static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> parseNumberValue(number))
                .sum();
    }

    public static int parseNumberValue(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new NegativeValueException(MESSAGE);
        }
        return number;
    }
}
