package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String SPLIT_DELIMITER = ",|:";

    public static int splitAndSum(String inputStr) {
        if (isBlank(inputStr)) {
            return 0;
        }

        return sum(split(inputStr));
    }

    private static boolean isBlank(String inputStr) {
        return inputStr == null || inputStr.isEmpty();
    }

    private static String[] split(String inputStr) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(inputStr);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputStr.split(SPLIT_DELIMITER);
    }

    private static int sum(String[] tokens) {
        int number = 0;

        for (String token : tokens) {
            if (isNumber(token) == false || isMinusNumber(token)) {
                throw new RuntimeException();
            }
            number = number + Integer.parseInt(token);
        }

        return number;
    }

    private static boolean isMinusNumber(String number) {
        return Integer.parseInt(number) < 0;
    }

    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
