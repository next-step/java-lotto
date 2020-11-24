package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int add(final String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            splitAndSum(matcher.group(2), customDelimiter);
        }
        return splitAndSum(input, DEFAULT_DELIMITER_REGEX);
    }

    private static int splitAndSum(final String expression, final String delimiter) {
        int sum = 0;
        String[] tokens = expression.split(delimiter);
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException();
            }

            sum += number;
        }

        return sum;
    }
}
