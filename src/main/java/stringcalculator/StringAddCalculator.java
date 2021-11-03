package stringcalculator;

import utils.DataParser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";


    public static int splitAndSum(String input) {
        return Arrays.stream(split(input))
                .map(DataParser::parseToInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        if (isCustomDelimiter(input)) {
            return getCustomDelimiterValue(input);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static String[] getCustomDelimiterValue(String input) {
        String[] tokens = null;
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

}
