package stringcalculator;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int MINUS_EXCEPTION_MINIMUM_VALUE = 0;
    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final int REGEX_GROUP_INDEX_DELIMITER = 1;
    private static final int REGEX_GROUP_INDEX_TEXT = 2;
    private static final String JOINER_DELIMITER = "|";
    private static final String SPLIT_DEFAULT_DELIMITERS = ",|:";
    private static final String REGEX_TEXT = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (validateNullOrEmpty(text)) {
            return DEFAULT_RETURN_VALUE;
        }
        String delimiters = getDelimiter(text);
        String numbers = getTextNumbers(text);
        return getSumStringNumbers(numbers, delimiters);
    }

    private static String getDelimiter(String text) {
        StringJoiner delimiters = new StringJoiner(JOINER_DELIMITER);
        delimiters.add(SPLIT_DEFAULT_DELIMITERS);
        Matcher matcher = Pattern.compile(REGEX_TEXT).matcher(text);
        if (matcher.find()) {
            delimiters.add(matcher.group(REGEX_GROUP_INDEX_DELIMITER));
        }
        return delimiters.toString();
    }

    private static String getTextNumbers(String text) {
        String resultText = text;
        Matcher matcher = Pattern.compile(REGEX_TEXT).matcher(text);
        if (matcher.find()) {
            resultText = matcher.group(REGEX_GROUP_INDEX_TEXT);
        }
        return resultText;
    }

    private static int getSumStringNumbers(String numbers, String delimiters) {
        if (validateNullOrEmpty(numbers)) {
            return DEFAULT_RETURN_VALUE;
        }
        int sumNumbers = DEFAULT_RETURN_VALUE;
        for (String number : numbers.split(delimiters)) {
            sumNumbers += toIntegerNumber(number);
        }
        return sumNumbers;
    }

    private static int toIntegerNumber(String number) {
        if (validateNotNumber(number)) {
            throw new RuntimeException("입력문자는 숫자만 가능합니다. 숫자가 아닌 문자가 입력되었습니다.");
        }
        if (validateMinusNumber(number)) {
            throw new RuntimeException("입력된 숫자는 음수일 수 없습니다.");
        }
        return Integer.parseInt(number);
    }

    private static boolean validateNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean validateMinusNumber(String number) {
        if (Integer.parseInt(number) < MINUS_EXCEPTION_MINIMUM_VALUE) {
            return true;
        }
        return false;
    }

    private static boolean validateNotNumber(String number) {
        boolean result = false;
        for (char c : number.toCharArray()) {
            result |= c < '0' || c > '9';
        }
        return result;
    }
}
