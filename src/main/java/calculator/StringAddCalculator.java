package calculator;

import utils.StringUtils;
import validator.StringAddCalculatorValidator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String COMMA_AND_COLON_DELIMITER = "[,|:]";
    private static final Pattern REGEX_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }

        if (StringUtils.isNumeric(input)) {
            return parseInt(input);
        }

        Matcher matcher = REGEX_CUSTOM_DELIMITER.matcher(input);
        if (matcher.find()) {
            return sum(matcher);
        }

        return sum(input.split(COMMA_AND_COLON_DELIMITER));
    }

    private static int sum(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] numberArray = matcher.group(2).split(customDelimiter);
        return sum(numberArray);
    }

    private static int sum(String[] numberArray) {
        return Arrays.stream(numberArray)
                .mapToInt(StringAddCalculator::parseInt)
                .sum();
    }

    private static int parseInt(String input) {
        int number = Integer.parseInt(input);
        StringAddCalculatorValidator.checkLessThanZero(number);
        return number;
    }
}