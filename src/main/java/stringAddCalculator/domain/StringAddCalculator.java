package stringAddCalculator.domain;

import stringAddCalculator.exceptin.StringAddCaculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] tokens = splite(input);
        return sum(tokens);
    }

    private static String[] splite(String input) {
        Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_SEPARATOR);
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String text : tokens) {
            result += parseString(text);
        }
        return result;
    }

    private static int parseString(String text) {
        int number;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new StringAddCaculatorException("입력값이 잘못되었습니다.");
        }

        if (number < 0) {
            throw new StringAddCaculatorException("음수 값을 입력할 수 없습니다.");
        }

        return number;
    }
}
