package calculator;

import helper.CollectionHelper;

import java.util.List;

import static constant.CalculatorConstant.CUSTOM_DELIMITER_PATTERN;
import static constant.CalculatorConstant.DEFAULT_SUM;
import static helper.StringHelper.*;

/**
 * @author han
 */
public class StringAddCalculator {

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return DEFAULT_SUM;
        }

        List<String> strings = splitByPattern(CUSTOM_DELIMITER_PATTERN, input);

        if (CollectionHelper.nullOrEmpty(strings)) {
            return sum(splitByCommaOrColon(input));
        }

        return sum(strings);
    }

    private int sum(List<String> numbers) {
        return numbers
            .stream()
            .mapToInt(this::parseInt)
            .sum();
    }

    private int parseInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
