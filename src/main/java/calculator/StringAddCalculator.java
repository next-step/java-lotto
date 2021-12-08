package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String TOKEN_DELIMITER = ",|:";
    private static final String REG_EXP = "//(.)\n(.*)";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        return sumNumbers(splitExpression(expression));
    }

    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static String[] splitExpression(String expression) {
        Matcher matcher = Pattern.compile(REG_EXP).matcher(expression);
        String delimiter = TOKEN_DELIMITER;

        if (matcher.find()) {
            delimiter = matcher.group(1);
            expression = matcher.group(2);
        }

        return expression.split(delimiter);
    }

}
