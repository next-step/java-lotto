package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static void main(String[] args) {

    }

    public static int splitAndSum(String input) {

        if (checkNullOrEmptyString(input)) {
            return 0;
        }

        if (checkOneDigitString(input)) {
            return checkMinusDigit(input);
        }

        return 0;
    }

    public static boolean checkNullOrEmptyString(String input) {

        if (input == null || input.length() == 0) {
            return true;
        }

        return false;
    }

    public static boolean checkOneDigitString(String input) {

        if (input.length() == 1) {
            return true;
        }

        return false;
    }

    public static int checkMinusDigit(String digitString) {

        int result = Integer.parseInt(digitString);

        if (result < 0) {
            throw new RuntimeException("음수입니다.");
        }

        return result;
    }

    public static int delimiterSum(String input) {

        int result = 0;

        String[] numbers = input.split(",|:");

        result = addString(numbers);

        return result;
    }

    public static int customDelimiterSum(String input) {

        int result = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            result += addString(tokens);
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
