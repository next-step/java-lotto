package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private StringAddCalculator() {}

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input))
            return 0;

        if (isOneNumber(input))
            return Integer.parseInt(input);

        if (isCustomSeparator(input))
            return findSeparatorAndSum(input);

        return getBasicSum(",|:", input);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null) return true;
        if (input.isEmpty()) return true;
        return false;
    }

    private static boolean isOneNumber(String input) {
        if (input.length() == 1)
            return true;
        return false;
    }

    private static boolean isCustomSeparator(String input) {
        if (input.startsWith("//"))
            return true;
        return false;
    }

    private static int findSeparatorAndSum(String input) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);
        String separator = ",|:";
        if (matcher.find()) {
            separator = matcher.group(1);
            input = matcher.group(2);
        }
        return getBasicSum(separator, input);
    }

    private static int getBasicSum(String separator, String input) {
        String[] splitValues = input.split(separator);
        int result = 0;
        for (String value : splitValues) {
            int number = Integer.parseInt(value);
            checkNegative(number);
            result += number;
        }
        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0)
            throw new RuntimeException("음수 값이 입력 되었습니다.");
    }

}
