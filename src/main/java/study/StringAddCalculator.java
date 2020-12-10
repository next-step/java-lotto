package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final static String DELIMITER = "[,:]";
    private final static String PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String string) {
        if (isNull(string) || isEmpty(string)) {
            return 0;
        }
        return sum(toInts(split(string)));
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
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return Arrays.asList(string.split(DELIMITER));
    }

    private static List<Integer> toInts(List<String> strings) {
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(StringAddCalculator::isNotNegativeNumber).sum();
    }

    private static int isNotNegativeNumber(int number) {
        if (isNegative(number)) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
