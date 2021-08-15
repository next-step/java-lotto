package calculator;

import util.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 */
public class StringPlusCalc {
    public static final int INPUT_MIN_VALUE = 0;
    public static final int CUSTOM_INPUT_DELIMITER_ORDER = 1;
    public static final int CUSTOM_INPUT_VALUE_ORDER = 2;
    public static final Pattern CUSTOM_INPUT_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        String[] strings = getEnteredSplit(string);

        inputValidation(strings);
        return getResult(strings);
    }

    private static int getResult(String[] strings) {
        int result = 0;

        for (String str : strings) {
            result += Integer.parseInt(str);
        }
        return result;
    }

    private static void inputValidation(String[] strings) {
        for (String str : strings) {
            boolean matches = Pattern.matches(Regex.ONLY_NUMBERS, str);

            isNotNumber(matches);
            isContainNegativeNumber(str);
        }
    }

    private static void isContainNegativeNumber(String str) {
        if (Integer.parseInt(str) < INPUT_MIN_VALUE) {
            throw new RuntimeException("You can not a entered negative number");
        }
    }

    private static void isNotNumber(boolean matches) {
        if (!matches) {
            throw new RuntimeException("You can entered only number");
        }
    }

    private static String[] getEnteredSplit(String string) {
        Matcher matcher = CUSTOM_INPUT_PATTERN.matcher(string);

        if (!matcher.find()) {
            return string.split(",|:");
        }

        String customDelimiter = matcher.group(CUSTOM_INPUT_DELIMITER_ORDER);
        return matcher.group(CUSTOM_INPUT_VALUE_ORDER).split(customDelimiter);
    }
}
