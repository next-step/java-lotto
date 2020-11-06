package humbledude.stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_SPLIT_TOKEN = ",|:";
    private static final String CUSTOM_SPLIT_TOKEN_PATTERN = "^//(.)\n(.*)$";

    public static int splitAndSum(String input) {
        int sum = 0;
        if (!isValidInput(input)) {
            return sum;
        }

        String splitToken = getSplitToken(input);
        String body = getBody(input);
        String[] strNumbers = body.split(splitToken);

        for (String strNumber : strNumbers) {
            int number = parseInt(strNumber);
            validateNumber(number);
            sum += number;
        }

        return sum;
    }

    private static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        if (input.isEmpty()) {
            return false;
        }

        return true;
    }

    private static String getSplitToken(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_TOKEN_PATTERN)
                .matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return DEFAULT_SPLIT_TOKEN;
    }

    private static String getBody(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_TOKEN_PATTERN)
                .matcher(input);

        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }

    private static int parseInt(String strNumber) {
        int number;
        try {
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 문자가 입력됨");
        }

        return number;
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 지원하지 않습니다");
        }
    }
}
