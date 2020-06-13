package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SEPARATOR_REGEX = "[,:]";

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        Matcher a = Pattern.compile("//.+\n").matcher(expression);
        if (a.find()) {
            String customSeparator = a.group()
                    .replace("//", "")
                    .replace("\n", "");
            return sum(expression.split("\n")[1].split(customSeparator));
        }
        return sum(expression.split(SEPARATOR_REGEX));
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(String[] intStrings) {
        return Arrays.stream(intStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
