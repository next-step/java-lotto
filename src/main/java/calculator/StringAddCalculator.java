package calculator;

import utils.StringUtils;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }

        if (StringUtils.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        return 3;
    }
}