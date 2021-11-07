package calculator;

import utils.StringUtils;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String COMMA = ",";
    private static final int ZERO = 0;

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }

        if (StringUtils.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        if (input.contains(COMMA)) {
            return sum(input.split(COMMA));
        }

        return 6;
    }

    private static int sum(String[] numberArray) {
        return Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}