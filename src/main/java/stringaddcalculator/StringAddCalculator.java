package stringaddcalculator;

import stringaddcalculator.util.StringUtil;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\n";

    public static int splitAndSum(String expression) {

        if (StringUtil.isBlank(expression)) {
            return 0;
        }

        if (expression.startsWith(CUSTOM_PREFIX)) {
            int lastIndex = expression.indexOf(CUSTOM_SUFFIX);
            String customDelimiter = expression.substring(CUSTOM_PREFIX.length(), lastIndex);
            String truncatedExpression = expression.substring(lastIndex + CUSTOM_SUFFIX.length());

            return sumSplitExpression(truncatedExpression.split(customDelimiter));
        }

        return sumSplitExpression(expression.split(DELIMITER));
    }

    private static int sumSplitExpression(String[] splitExpression) {
        return Arrays.stream(splitExpression)
                .mapToInt(Integer::parseInt)
                .reduce(0, (total, number) -> total + number)
                ;
    }
}
