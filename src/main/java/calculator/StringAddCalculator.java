package calculator;

import java.util.List;
import java.util.Objects;

import static constant.CalculatorConstant.CUSTOM_DELIMITER_PATTERN;
import static constant.CalculatorConstant.DEFAULT_SUM;
import static helper.StringHelper.*;

/**
 * @author han
 */
public class StringAddCalculator {

    private static List<String> strings;

    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return DEFAULT_SUM;
        }

        strings = splitByPattern(CUSTOM_DELIMITER_PATTERN, input);

        if (Objects.isNull(strings) || strings.isEmpty()) {
            strings = splitByCommaOrColon(input);
        }

        return sum(strings);
    }

    private static int sum(List<String> numbers) {
        return numbers
            .stream()
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
