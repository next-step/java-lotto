package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String delimiterRegx = "//(.)\\n(.*)";

    public static int splitAndSum(String input) {
        if (isStringBlank(input)) {
            return 0;
        }

        if (!isContainDelimiter(input)) {
            return convertTextToInt(input);
        }

        String[] numbers = splitInput(input);
        return calculateSum(numbers);
    }

    private static boolean isStringBlank(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isContainDelimiter(String input) {
        return hasBasicDelimiter(input) || input.matches(delimiterRegx);
    }

    private static boolean hasBasicDelimiter(String input) {
        return input.contains(",") || input.contains(":");
    }

    private static int convertTextToInt(String number) {
        int num = Integer.parseInt(number);
        negativeNumberCheck(num);
        return num;
    }

    private static void negativeNumberCheck(int num) {
        if (num < 0) {
            throw new RuntimeException("음수입니다.");
        }
    }

    private static String[] splitInput(String input) {
        if (!hasBasicDelimiter(input)) {
            return customDelimiterSplit(input);
        }
        return input.split(",|:");
    }

    private static String[] customDelimiterSplit(String input) {
        Matcher m = Pattern.compile(delimiterRegx).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private static int calculateSum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::convertTextToInt).sum();
    }
}
