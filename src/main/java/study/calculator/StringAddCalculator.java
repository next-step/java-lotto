package study.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASE_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        return new Numbers(split(input)).sum();
    }

    private static String[] split(String input) {
        if(input.startsWith("//")) {
            return splitWithCustomDelimiter(input);
        }

        return input.split(BASE_DELIMITER);
    }

    private static String[] splitWithCustomDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);

            return m.group(2).split(customDelimiter);
        }

        return null;
    }


}
