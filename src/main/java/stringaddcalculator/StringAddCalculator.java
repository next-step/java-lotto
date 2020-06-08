package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String SEPARATOR = ",|:";

    private StringAddCalculator() {}

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        if (isOneNumber(input)) {
            return Integer.parseInt(input);
        }

        if (isCustomSeparator(input)) {
            return findSeparatorAndSum(input);
        }

        return sum(SEPARATOR, input);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }
        return input.isEmpty();
    }

    private static boolean isOneNumber(String input) {
        return input.length() == 1;
    }

    private static boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private static int findSeparatorAndSum(String input) {
        Matcher matcher = PATTERN.matcher(input);
        String separator = SEPARATOR;
        if (matcher.find()) {
            separator = matcher.group(1);
            input = matcher.group(2);
        }
        return sum(separator, input);
    }

    private static int sum(String separator, String input) {
        String[] splitValues = input.split(separator);
        int result = 0;
        for (String value : splitValues) {
            int number = Integer.parseInt(value);
            checkNegative(number);
            result += number;
        }
        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0){
            throw new RuntimeException("음수 값이 입력 되었습니다.");
        }

    }

}
