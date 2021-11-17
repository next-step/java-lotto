package calculator;

import java.util.Arrays;

import static constant.CalculatorConstant.CUSTOM_DELIMITER_PATTERN;
import static constant.CalculatorConstant.DEFAULT_SUM;
import static helper.StringHelper.nullOrEmpty;
import static helper.StringHelper.splitByPattern;

/**
 * @author han
 */
public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return DEFAULT_SUM;
        }

        return sum(splitByPattern(CUSTOM_DELIMITER_PATTERN, input));
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
