package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {
    private InputUtil() {
    }

    public static String[] paresNumber(String input) {
        validationInput(input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(";|,");
    }

    private static void validationInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }
}
