package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final String BASIC_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher matcher = getCustomDelimiterMatcher(input);
        if (matcher.find()) {
            return splitWithCustomDelimiter(matcher).stream()
                    .reduce(0, Integer::sum);
        }
        return split(input).stream()
                .reduce(0, Integer::sum);
    }

    static List<Integer> split(String input) {
        return Arrays.stream(input.split(BASIC_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    static List<Integer> splitWithCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return Arrays.stream(matcher.group(2).split(customDelimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    static Matcher getCustomDelimiterMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}
