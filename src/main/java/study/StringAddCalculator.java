package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (isNull(string) || isEmpty(string)) {
            return 0;
        }
        return stringsSum(split(string));
    }

    private static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    private static boolean isNull(String string) {
        return string == null;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static List<String> split(String string) {
        List<String> strings = Arrays.asList(string.split("[,:]"));
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            strings = Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return strings;
    }

    private static int stringsSum(List<String> strings) {
        return strings.stream()
                .mapToInt(s -> {
                    int number = Integer.parseInt(s);
                    if (isNegative(number)) {
                        throw new RuntimeException();
                    }
                    return number;
                }).sum();
    }
}
