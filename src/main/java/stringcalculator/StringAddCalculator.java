package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int MINUS_EXCEPTION_MINIMUM_VALUE = 0;
    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final int REGEX_GROUP_INDEX_DELIMITER = 1;
    private static final int REGEX_GROUP_INDEX_TEXT = 2;
    private static final String SPLIT_DEFAULT_DELIMITERS = ",|:";
    private static final String REGEX_TEXT = "//(.)\n(.*)";
    private static final String DELIMITER_JOINER = "|";

    public static int splitAndSum(String text) {
        if (validateNullOrEmpty(text)) {
            return DEFAULT_RETURN_VALUE;
        }
        String delimiter = getDelimiter(text);
        String textNumber = getTextNumber(text);
        return sumTextNumber(textNumber, delimiter);
    }

    private static String getDelimiter(String text) {
        Matcher matcher = Pattern.compile(REGEX_TEXT).matcher(text);
        if (matcher.find()) {
            return SPLIT_DEFAULT_DELIMITERS + DELIMITER_JOINER + matcher.group(REGEX_GROUP_INDEX_DELIMITER);
        }
        return SPLIT_DEFAULT_DELIMITERS;
    }

    private static String getTextNumber(String text) {
        Matcher matcher = Pattern.compile(REGEX_TEXT).matcher(text);
        if (matcher.find()) {
            return matcher.group(REGEX_GROUP_INDEX_TEXT);
        }
        return text;
    }

    private static int sumTextNumber(String textNumber, String delimiter) {
        if (validateNullOrEmpty(textNumber)) {
            return DEFAULT_RETURN_VALUE;
        }
        int sumNumber = DEFAULT_RETURN_VALUE;
        for (String number : textNumber.split(delimiter)) {
            sumNumber += toIntegerNumber(number);
        }
        return sumNumber;
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
        return text == null || text.isEmpty();
    }

    private static boolean validateMinusNumber(String number) {
        return Integer.parseInt(number) < MINUS_EXCEPTION_MINIMUM_VALUE;
    }

    private static boolean validateNotNumber(String number) {
        boolean result = false;
        for (char c : number.toCharArray()) {
            result |= c < '0' || c > '9';
        }
        return result;
    }
}
