package StringAddCalculator;

import StringAddCalculator.utils.checkDelimiter;
import StringAddCalculator.utils.checkString;

public class StringAddCalculator {

    public static final int ADD_NULL_OR_BLANK = 0;

    public static int splitAndSum(String expression) {
        if (checkString.isNullOrBlank(expression)) {
            return ADD_NULL_OR_BLANK;
        }
        int result = toInt(toSplits(expression)[0]);
        for (int i = 1; i < toSplits(expression).length; i += 2) {
            String delimiter = toSplits(expression)[i];
            int second = toInt(toSplits(expression)[i + 1]);
            if (!checkDelimiter.isRightDelimiter(delimiter) || checkString.isNullOrBlank(delimiter)) {
                return result;
            }
            result = result + second;
        }
        return result;
    }

    private static int toInt(String expression) {
        return Integer.parseInt(expression);
    }

    private static String[] toSplits(String expression) {
        if (checkString.isNullOrBlank(expression)) {
            expression = "0";
        }
        String[] expressions = expression.split("");
        return expressions;
    }
}
