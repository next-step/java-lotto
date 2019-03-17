package calculator;

import spark.utils.StringUtils;

public class StringAdditionCalculator {

    private static final int EXPRESSION_NULL_OR_EMPTY = 0;

    public static int validateInput(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return EXPRESSION_NULL_OR_EMPTY;
        }
        return 1;
    }
}
