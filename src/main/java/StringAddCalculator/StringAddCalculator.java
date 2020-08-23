package StringAddCalculator;

import StringAddCalculator.utils.checkDelimiter;
import StringAddCalculator.utils.checkString;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static final int ADD_NULL_OR_BLANK = 0;

    public static int splitAndSum(String expression) {
        if (checkString.isNullOrBlank(expression)) {
            return ADD_NULL_OR_BLANK;
        }
        int result = toInt(toSplits(expression)[0]);
        for (int i = 1; i < toSplits(expression).length; i++) {
            int second = toInt(toSplits(expression)[i]);
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
        String[] expressions = expression.split(",");
        return expressions;
    }

    public static int splitAndSum2(String expression) {
        String[] initExpression = expression.split("");
        int result = toInt(initExpression[0]);
        for (int i = 1; i < initExpression.length; i += 2) {
            String delimiter = initExpression[i];
            int second = toInt(initExpression[i + 1]);
            if (!checkDelimiter.isRightDelimiter(delimiter)) {
                return ADD_NULL_OR_BLANK;
            }
            result = result + second;
        }
        return result;
    }
//
//            for (int j = 0; j < delimiters.size(); j++) {
//                if (delimiters.get(j) == Delimiter.of(delimiter).toString()) {
//                    String[] expressions = expression.split(regex.toString());
//
//                    initExpressions = expressions;
//                }
//                return initExpressions;
//            }

}
