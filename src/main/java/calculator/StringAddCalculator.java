package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) return 0;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] nums = (matcher.find()) ? splitByDelimiter(matcher.group(1), matcher.group(2)) : splitByDelimiter(DEFAULT_DELIMITER, text);
        return sum(nums);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.trim().length() == 0;
    }

    private static String[] splitByDelimiter(String delimiter, String text) {
        return text.split(delimiter);
    }

    private static int toInt(String stringNumber) {
        for (char c : stringNumber.toCharArray()) {
            validateDigit(c);
        }
        return Integer.parseInt(stringNumber);
    }

    public static void validateDigit(char num) {
        if (!Character.isDigit(num)) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static int sum(String[] nums) {
        int sum = 0;
        for (String num : nums) {
            sum += toInt(num);
        }
        return sum;
    }
}
