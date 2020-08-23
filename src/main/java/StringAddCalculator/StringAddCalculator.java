package StringAddCalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static StringAddCalculator.utils.CheckCustomDelimiter.isInvalidCustomDelimiter;
import static StringAddCalculator.utils.CheckDelimiter.isInvalidDelimiter;
import static StringAddCalculator.utils.CheckString.isNullOrBlank;

public class StringAddCalculator {

    public static final int ADD_NULL_OR_BLANK = 0;
    public static final Pattern COMPILER_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int AFTER_CUSTOM_DELIMITER_INDEX = 2;

    // 음? 커스텀구분자로 m.group(2).split(cus)한 후에는 각 구분자 맞는지 확인할 필요는 없나? 확인하려고 하면 에러발생
    // if (isInvalidCustomDelimiter(nextExpressions[i], customDelimiter)) { return result2;}

    public static int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return ADD_NULL_OR_BLANK;
        }
        Matcher m = COMPILER_CUSTOM_DELIMITER.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            String[] afterDelimiterExpressions = m.group(AFTER_CUSTOM_DELIMITER_INDEX).split(customDelimiter);
            return sumWhenCustomDelimiter(afterDelimiterExpressions);
        }
        return sumWhenOriginalDelimiter(expression);
    }

    private static int sumWhenOriginalDelimiter(String expression) {
        int result = findNumber(expression, 0);
        for (int i = 1; i < toSplits(expression).length; i += 2) {
            if (isInvalidDelimiter(toSplits(expression)[i])) {
                return result;
            }
            int nextNumber = findNumber(expression, i + 1);
            result = result + nextNumber;
        }
        return result;
    }

    private static int sumWhenCustomDelimiter(String[] nextExpressions) {
        int result = findNumber2(nextExpressions, 0);
        for (int i = 1; i < nextExpressions.length; i ++) {
            int nextNumber2 = findNumber2(nextExpressions, i);
            result = result + nextNumber2;
        }
        return result;
    }

    private static int findNumber2(String[] expressions, int i) {
        return Integer.parseInt(expressions[i]);
    }

    private static int findNumber(String expression, int i) {
        return findNumber2(toSplits(expression), i);
    }

    private static String[] toSplits(String expression) {
        if (isNullOrBlank(expression)) {
            expression = "0";
        }
        String[] expressions = expression.split("");
        return expressions;
    }
}
