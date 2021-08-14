package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalc {

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
            boolean matches = Pattern.matches("^[0-9]*$", str);

            isNotNumber(matches);
            isContainNegativeNumber(str);
        }
    }

    private static void isContainNegativeNumber(String str) {
        if (Integer.parseInt(str) < 0) {
            throw new RuntimeException("You can not a entered negative number");
        }
    }

    private static void isNotNumber(boolean matches) {
        if (!matches) {
            throw new RuntimeException("You can entered only number");
        }
    }

    private static String[] getEnteredSplit(String string) {
        String[] strings;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);

        if (!matcher.find()) {
            return strings = string.split(",|:");
        }

        String customDelimiter = matcher.group(1);
        strings = matcher.group(2).split(customDelimiter);
        return strings;
    }
}
