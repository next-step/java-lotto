package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int NUMBER_START_INDEX = 2;
    private static final int DELIMITER_INDEX = 1;
    private static final int MIN_NUMBER = 0;
    private static final Pattern INPUT_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(convertStringToInt(splitInputValue(input)));
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String[] splitInputValue(String input) {
        Matcher matcher = INPUT_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            return input.split(",|:");
        }

        return matcher.group(NUMBER_START_INDEX).split(matcher.group(DELIMITER_INDEX));
    }

    private static int[] convertStringToInt(String[] inputTokens) {
        int[] numbers = new int[inputTokens.length];
        for (int i = 0; i < inputTokens.length; i++) {
            int number = Integer.parseInt(inputTokens[i]);
            validateNumber(number);

            numbers[i] = number;
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new RuntimeException();
        }
    }
}
