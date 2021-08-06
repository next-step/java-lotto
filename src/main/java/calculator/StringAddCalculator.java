package calculator;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String PIPE = "|";
    private static final int DEFAULT_RESULT = 0;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public int calculate(String input) {
        if (verify(input)) {
            return DEFAULT_RESULT;
        }
        return getSum(split(input));
    }

    private boolean verify(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        if (input.contains("-")) {
            throw new RuntimeException("음수가 포함되어 있습니다. input : " + input);
        }
        return false;
    }

    private String[] split(String input) {
        String delimiter = getDelimiter(input);
        return getExpression(input).split(delimiter);
    }

    private String getDelimiter(String input) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            delimiter += PIPE + matcher.group(1);
        }
        return delimiter;
    }

    private String getExpression(String input) {
        String[] split = pattern.split(input);
        return split[split.length - 1];
    }

    private int getSum(String[] split) {
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
}
