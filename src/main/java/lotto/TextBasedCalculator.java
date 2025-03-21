package lotto;

import java.util.regex.Pattern;

public class TextBasedCalculator {
    public static boolean validate(String input) {
        String validFormatRegex = "^-?\\d+(\\s[+\\-*/]\\s-?\\d+)*$";
        String divideByZeroRegex = ".*\\/\\s-?0(\\s|$).*";

        if (!Pattern.matches(validFormatRegex, input)) {
            return false;
        }

        if (Pattern.matches(divideByZeroRegex, input)) {
            return false;
        }

        return Pattern.matches(validFormatRegex, input);
    }
}
