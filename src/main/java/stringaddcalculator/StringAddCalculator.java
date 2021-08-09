package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_SPLITTER_REGEX = "//(.+)\n";
    private static final Pattern CUSTOM_SPLITTER_PATTERN = Pattern.compile(CUSTOM_SPLITTER_REGEX);
    private static final String SPLITTER_SEPARATOR = "|";
    private static final String[] DEFAULT_SPLITTERS = {",", ":"};

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(split(input));
    }

    private static String[] split(String input) {
        StringBuffer sb  = new StringBuffer(String.join(SPLITTER_SEPARATOR, DEFAULT_SPLITTERS));

        Matcher matcher = CUSTOM_SPLITTER_PATTERN.matcher(input);
        if (matcher.find()) {
            sb.append(SPLITTER_SEPARATOR);
            sb.append(matcher.group(1));
            input = input.split(CUSTOM_SPLITTER_REGEX)[1];
        }

        return input.split(sb.toString());
    }

    private static int sum(String[] splits) {
        return Arrays.stream(splits)
            .mapToInt(Integer::parseInt)
            .peek(StringAddCalculator::validateNegative)
            .reduce(0, Integer::sum);
    }

    private static void validateNegative(int inputNumber) {
        if (inputNumber < 0) {
            throw new RuntimeException("음수는 처리할 수 없습니다.");
        }
    }
}
