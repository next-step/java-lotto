package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int calculate(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        String[] splitInput = split(matcher, input);

        return sum(splitInput);
    }

    private static String[] split(Matcher matcher, String input) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] splitInput) {
        Numbers numbers = new Numbers(splitInput);
        return numbers.sum();
    }
}
