package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final static String DELIMITER = "[,:]";
    private final static String PATTERN = "//(.)\n(.*)";
    private final static int ZERO = 0;
    private final static int FIRST = 1;
    private final static int SECOND = 2;

    public static int splitAndSum(String string) {
        if (isUnusable(string)) {
            return 0;
        }
        return sum(toInts(split(string)));
    }

    private static boolean isUnusable(String string) {
        return isNull(string) || isEmpty(string);
    }

    private static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    private static boolean isNull(String string) {
        return string == null;
    }

    private static List<String> split(String string) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(string);
        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST);
            return Arrays.asList(matcher.group(SECOND).split(customDelimiter));
        }
        return Arrays.asList(string.split(DELIMITER));
    }

    private static List<Integer> toInts(List<String> strings) {
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(StringAddCalculator::toNotNegativeNumber).sum();
    }

    private static int toNotNegativeNumber(int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNegative(int number) {
        return number < ZERO;
    }
}
