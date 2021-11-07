package calculator;

import utils.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String COMMA_AND_COLON = ",|:";

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }

        if (StringUtils.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        return sum(input.split(COMMA_AND_COLON));
    }

    private static int sum(String[] numberArray) {
        return Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}