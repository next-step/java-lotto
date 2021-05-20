package kr.insup.calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final Pattern pattern = Pattern.compile("^//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[:,]";

    public static int stringToIntConverter(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        if (!number.matches("\\d+")) {
            throw new NumberFormatException("숫자 형식이 맞지 않습니다");
        }
        return Integer.parseInt(number);
    }

    public static String getDelimiter(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String delimiter = m.group(1);
            return escapeCharacter(delimiter);
        }
        return DEFAULT_DELIMITER;
    }

    public static String getOnlyNumbers(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            return m.group(2);
        }
        return input;
    }

    private static String escapeCharacter(String delimiter) {
        if ("\\[](){}*+?|^$.".contains(delimiter)) {
            return "\\" + delimiter;
        }
        return delimiter;
    }
}
