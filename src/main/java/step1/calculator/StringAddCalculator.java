package step1.calculator;

import step1.number.Numbers;
import step1.separator.Separator;

import static utils.StringUtils.isNullOrBlank;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }
        Separator separator = new Separator(expression);
        Numbers numbers = new Numbers(separator.splitByDelimiter());
        return numbers.sum();
    }

}
