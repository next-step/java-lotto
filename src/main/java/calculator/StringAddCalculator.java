package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int PATTERN_GROUP_ONE = 1;
    public static final int PATTERN_GROUP_TWO = 2;
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static void main(String[] args) {
        String addString = "1,2,3";
        int result = splitAndSum(addString);
        System.out.println(addString + "==>" + result);
    }

    public static int splitAndSum(String input) {

        if (checkNullOrEmptyString(input)) {
            return ZERO;
        }

        if (checkOneDigitString(input)) {
            return checkMinusDigit(input);
        }

        return checkDelimeter(input);
    }

    public static boolean checkNullOrEmptyString(String input) {

        return input == null || input.length() == ZERO;
    }

    public static boolean checkOneDigitString(String input) {

        return input.length() == ONE;
    }

    public static int checkMinusDigit(String digitString) {

        int result = Integer.parseInt(digitString);

        if (result < ZERO) {
            throw new RuntimeException("음수입니다.");
        }

        return result;
    }

    public static int checkDelimeter(String input) {

        if (input.charAt(ZERO) == '/') {
            return customDelimiterSum(input);
        }

        return delimiterSum(input);
    }

    public static int delimiterSum(String input) {

        String[] numbers = input.split(",|:");
        return addString(numbers);
    }

    public static int customDelimiterSum(String input) {

        int result = 0;
        Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(PATTERN_GROUP_ONE);
            String[] tokens = m.group(PATTERN_GROUP_TWO).split(customDelimiter);
            result = addString(tokens);
        }
        return result;
    }

    public static int addString(String[] numbers) {

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            result += checkMinusDigit(numbers[i]);
        }

        return result;
    }

}
