package step1;

import step1.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DELIMITER_REGEX = "//(.)\n(.*)";
    public static final Pattern DELIMITER_PATTERN = Pattern.compile(DELIMITER_REGEX);

    public static final int TEXT_GROUP = 2;
    public static final int DELIMITER_GROUP = 1;

    private StringAddCalculator() {}

    public static int splitAndSum(String target) {
        if (StringUtils.isEmpty(target)) {
            return 0;
        }
        Expression expression = createExpression(target);
        return expression.calculate();
    }

    private static Expression createExpression(String target) {
        Matcher m = DELIMITER_PATTERN.matcher(target);
        if (m.find()) {
            return Expression.of(m.group(TEXT_GROUP), m.group(DELIMITER_GROUP));
        }
        return Expression.of(target);
    }
}
