package study.calculator;

import study.calculator.model.Numbers;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASE_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private static Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static int calculate(String input) {
        if(Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        Numbers numbers = new Numbers(split(input));

        return numbers.sum();
    }

    private static String[] split(String input) {
        Matcher m = pattern.matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(BASE_DELIMITER);
    }
}
