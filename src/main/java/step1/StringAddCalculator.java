package step1;

import step1.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private StringAddCalculator() {}

    public static final String DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String target) {
        if (StringUtils.isEmpty(target)) {
            return 0;
        }
        Expression expression = createExpression(target);
        return expression.stream().reduce(0, (acc, cur) -> acc += cur);
    }

    private static Expression createExpression(String target) {
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(target);
        if (m.find()) {
            return Expression.of(m.group(2), m.group(1));
        }
        return Expression.of(target);
    }
}
