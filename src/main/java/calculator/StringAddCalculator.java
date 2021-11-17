package calculator;

import constant.NumberConstant;
import helper.StringHelper;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author han
 */
public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (StringHelper.nullOrEmpty(input)) {
            return NumberConstant.DEFAULT_SUM;
        }

        return sum(StringHelper.splitByPattern(CUSTOM_DELIMITER_PATTERN, input));
    }

    private static int sum(String[] numbers) {
        return Arrays
            .stream(numbers)
            .mapToInt(StringAddCalculator::parseInt)
            .sum();
    }

    private static int parseInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
