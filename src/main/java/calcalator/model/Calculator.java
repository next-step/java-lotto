package calcalator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static boolean isEmpty(String input) {
        return input == null || "".equals(input);
    }

    public static int parse(String input) throws NumberFormatException {
        if (isEmpty(input))
            return 0;
        return Integer.parseInt(input);
    }

    public static String[] split(String input, String delimiter) {
        return input.split(customDelimiter(delimiter));
    }

    public static String[] split(String input) {
        return split(input, ",");
    }

    public static String customDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return input;
    }

}
