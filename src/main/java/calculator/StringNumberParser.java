package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringNumberParser {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_START_STRING = "//";
    private static final String CUSTOM_SEPARATOR_END_STRING = "\n";

    public static List<Integer> parse(String string) {
        String separator = getSeparator(string);
        String[] strings = split(string, separator);
        return convertNumbers(strings);
    }

    private static String getSeparator(String string) {
        if (hasCustomSeparator(string)) {
            return findCustomSeparator(string);
        }

        return DEFAULT_SEPARATOR;
    }

    private static boolean hasCustomSeparator(String string) {
        return string.contains(CUSTOM_SEPARATOR_START_STRING) && string.contains(CUSTOM_SEPARATOR_END_STRING);
    }

    private static String findCustomSeparator(String string) {
        int startIndex = string.indexOf(CUSTOM_SEPARATOR_START_STRING) + CUSTOM_SEPARATOR_START_STRING.length();
        int endIndex = string.indexOf(CUSTOM_SEPARATOR_END_STRING);
        return string.substring(startIndex, endIndex);
    }

    private static String[] split(String string, String separator) {
        if (hasCustomSeparator(string)) {
            int beginIndex = string.indexOf(CUSTOM_SEPARATOR_END_STRING) + CUSTOM_SEPARATOR_END_STRING.length();
            return string.substring(beginIndex).split(separator);
        }
        return string.split(separator);
    }

    private static List<Integer> convertNumbers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : strings) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
