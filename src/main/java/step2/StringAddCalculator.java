package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    public static final String CHARACTER_OR_NEGATIVE_NUMBER_ERROR = "문자와 음수는 입력이 불가능 합니다.";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        String beforeSplit = input;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            beforeSplit = matcher.group(2);
        }

        String[] splitNumbers = splitDelimiter(beforeSplit, delimiter);
        Arrays.stream(splitNumbers).forEachOrdered(StringAddCalculator::isDigit);

        return add(Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt)
                .toArray());
    }

    private static String[] splitDelimiter(String beforeSplit, String delimiter) {
        return beforeSplit.split(delimiter);
    }

    private static void isDigit(String splitNumbers) {
        if (!splitNumbers.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
        }
    }

    private static int add(int[] numbers) {

        int sum = 0;
        for (int number : numbers) {
            minusNumberCheck(number);
            sum += number;
        }

        return sum;
    }

    private static void minusNumberCheck(int number) {
        if (number < 0) {
            throw new RuntimeException(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
        }
    }
}
