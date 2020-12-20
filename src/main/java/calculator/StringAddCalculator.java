package calculator;

import util.ValidateUtils;

public class StringAddCalculator {
    private static final int DEFAULT_NUM = 0;

    public static int splitAndSum(String input) {
        if (ValidateUtils.isEmpty(input)) {
            return DEFAULT_NUM;
        }

        Numbers numbers = new Numbers(new StringSplitor(input));
        return numbers.sum();
    }
}
