package step1.calculator;

import step1.number.Numbers;
import step1.separator.Separator;

import static utils.StringUtils.isNullOrBlank;

public final class StringAddCalculator {
    private static final int NO_VALUE = 0;

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return NO_VALUE;
        }
        Separator separator = new Separator(expression);
        Numbers numbers = new Numbers(separator.splitByDelimiter());
        return numbers.sum();
    }

}
