package calculator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DELIMITER_COMMA = ",";
    public static final String DELIMITER_COLON = ":";
    public static final String CUSTOM_DELIMITER_BEGIN = "//";
    public static final String CUSTOM_DELIMITER_END = "\n";

    private static final String FAILURE_PARSE_MESSAGE = "Cannot be parsed as a number: \"{0}\"";
    private static final String NEGATIVE_NUMBER_MESSAGE = "Negative numbers are not available: \"{0}\"";

    public static int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>(Arrays.asList(DELIMITER_COMMA, DELIMITER_COLON));
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_BEGIN + "(.)" + CUSTOM_DELIMITER_END + "(.*)")
                .matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(customDelimiter);
            input = matcher.group(2);
        }

        return calculate(input, delimiters);
    }

    private static int calculate(String input, List<String> delimiters) {
        String[] parts = input.split(String.join("|", delimiters));
        int result = 0;
        for (String part : parts) {
            int num = parseInt(part);
            verifyNegativeNumber(num);
            result += num;
        }
        return result;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(MessageFormat.format(FAILURE_PARSE_MESSAGE, input));
        }
    }

    private static void verifyNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(MessageFormat.format(NEGATIVE_NUMBER_MESSAGE, number));
        }
    }
}
