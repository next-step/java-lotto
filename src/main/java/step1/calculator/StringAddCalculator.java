package step1.calculator;


import java.util.Arrays;

import static utils.StringUtils.isNullOrBlank;
import static utils.StringUtils.splitByCommaAndColon;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }
        return sum(splitByCommaAndColon(expression));
    }

    private static final int sum(String[] data) {
        return Arrays.stream(data)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
