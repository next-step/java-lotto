package calculation;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "error : 음수는 사용할수 없습니다.";
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String SPLIT_CONDITION = ",|:";

    private StringAddCalculator(){
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return patternMatch(text);
    }

    private static int patternMatch(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN).matcher(text);

        String[] numbers;
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter);

            return textToNumber(numberArray(numbers));
        }

        numbers = text.split(SPLIT_CONDITION);
        return textToNumber(numberArray(numbers));
    }

    private static int[] numberArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int textToNumber(int[] numbers) {
        checkNegativeNumber(numbers);

        if (numbers.length == 1) {
            return numbers[0];
        }

        return calculate(numbers);
    }

    private static void checkNegativeNumber(int[] numbers) {
        long count = Arrays.stream(numbers)
                .filter(i -> i < 0)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static int calculate(int[] numbers) {
        int loopNumber = numbers.length - 1;
        int result = 0;
        for (int i = 0; i < loopNumber; i++) {
            result = firstNumber(result, numbers[i]);
            result = Calculation.calculate("+", result, numbers[i + 1]);
        }

        return result;
    }

    private static int firstNumber(int result, int firstNumber) {
        if (result == 0) {
            return firstNumber;
        }
        return result;
    }

}
