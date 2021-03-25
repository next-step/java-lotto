package step1.calculator;

import step1.number.PositiveNumbers;
import step1.separator.Separator;

import static utils.StringUtils.isNullOrBlank;

public final class StringAddCalculator {
    private static final int NO_VALUE = 0;

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return NO_VALUE;
        }
        Separator separator = new Separator(expression);
        PositiveNumbers positiveNumbers = new PositiveNumbers(separator.splitByDelimiter());
        return positiveNumbers.sum();
    }

}
