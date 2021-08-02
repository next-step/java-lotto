package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String OR = "|";
    private static final int SECOND_GROUP_INDEX = 1;
    private static final int THIRD_GROUP_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        int[] numbers = extractNumbers(input);
        return Arrays.stream(numbers)
                .reduce(0, Integer::sum);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int[] extractNumbers(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(SECOND_GROUP_INDEX);
            delimiters += OR + customDelimiter;
            input = matcher.group(THIRD_GROUP_INDEX);
        }

        String[] numbers = input.split(delimiters);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
