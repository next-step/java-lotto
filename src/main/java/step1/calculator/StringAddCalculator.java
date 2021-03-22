package step1.calculator;


import static utils.StringUtils.isNullOrBlank;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }
        return 1;
    }

}
