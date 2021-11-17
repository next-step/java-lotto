package calcalator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",";

    public static boolean isEmpty(String input) {
        return input == null || "".equals(input);
    }

    public static int parse(String input) throws NumberFormatException {
        if (isEmpty(input))
            return 0;
        return Integer.parseInt(input);
    }

    public static String[] split(String input) {
        return split(input, DEFAULT_DELIMITER);
    }

    public static String[] split(String input, String delimiter) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(delimiter);
    }

}
