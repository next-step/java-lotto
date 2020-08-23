package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static StringAddCalculator.utils.CheckCustomDelimiter.isInvalidCustomDelimiter;
import static StringAddCalculator.utils.CheckDelimiter.isInvalidDelimiter;
import static StringAddCalculator.utils.CheckString.isNullOrBlank;

public class StringAddCalculator {

    public static final int ADD_NULL_OR_BLANK = 0;

    // matcher로 //(.)\n 여부 확인
    // m.find() true 이면 그 커스텀구분자 & 구분자로 덧셈 진행 -- enum 등록은 못하지만
    // false이면  원래 아래 과정 진행
    public static int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return ADD_NULL_OR_BLANK;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] nextExpressions = m.group(2).split(customDelimiter);
            int result2 = Integer.parseInt(nextExpressions[0]);
            for (int i = 1; i < nextExpressions.length; i ++) {
//                if (isInvalidCustomDelimiter(nextExpressions[i], customDelimiter)) {
//                    return result2;
//                }
                int nextNumber2 = Integer.parseInt(nextExpressions[i]);
                result2 = result2 + nextNumber2;
            }
            return result2;
        }
        int result2 = findNumber(expression, 0);
        for (int i = 1; i < toSplits(expression).length; i += 2) {
            if (isInvalidDelimiter(toSplits(expression)[i])) {
                return result2;
            }
            int nextNumber = findNumber(expression, i + 1);
            result2 = result2 + nextNumber;
        }
        return result2;
    }

    private static int findNumber(String expression, int i) {
        return Integer.parseInt(toSplits(expression)[i]);
    }

    private static String[] toSplits(String expression) {
        if (isNullOrBlank(expression)) {
            expression = "0";
        }
        String[] expressions = expression.split("");
        return expressions;
    }
}
