package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_SEPARATOR =  ",|:";

    public static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customSeparator = m.group(1);
            return m.group(2).split(customSeparator);
        }

        return input.split(DEFAULT_SEPARATOR);
    }
}
