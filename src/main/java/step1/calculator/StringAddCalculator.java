package step1.calculator;

import step1.number.Numbers;

import static utils.StringUtils.isNullOrBlank;
import static utils.StringUtils.splitByCommaAndColon;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }

        Numbers numbers = new Numbers(splitByCommaAndColon(expression));
        return numbers.sum();
    }

}
