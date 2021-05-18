package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(splitByDelimiter(input));

    }

    private static String[] splitByDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private static int sum(String[] splits) {
        int result = 0;
        for (String split : splits) {
            result += parseIntPositive(split);
        }
        return result;
    }

    private static int parseIntPositive(String split) {
        int result = Integer.parseInt(split);
        if (result < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return result;
    }
}
