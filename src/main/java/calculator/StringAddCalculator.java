package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR_REGEX = "[,:]";

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        String[] intStrings = split(expression);
        return sum(intStrings);
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static String[] split(String expression) {
        Matcher a = Pattern.compile("//.+\n").matcher(expression);
        if (a.find()) {
            String customSeparator = a.group()
                    .replace("//", "")
                    .replace("\n", "");
            return expression.split("\n")[1].split(customSeparator);
        }
        return expression.split(DEFAULT_SEPARATOR_REGEX);
    }

    private static int sum(String[] intStrings) {
        return Arrays.stream(intStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
