package step1.calculator;


import java.util.Arrays;

import static utils.StringUtils.isNullOrBlank;
import static utils.StringUtils.splitByComma;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }
        return sum(splitByComma(expression));
    }

    private static final int sum(String[] data) {
        return Arrays.stream(data)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
