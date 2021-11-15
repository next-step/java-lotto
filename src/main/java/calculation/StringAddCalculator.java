package calculation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String SPLIT_CONDITION = ",|:";
    private static final int NULL_AND_EMPTY_ZERO = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return NULL_AND_EMPTY_ZERO;
        }

        return calculate(patternMatch(text));
    }

    private static String[] patternMatch(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            return matcher.group(2).split(customDelimiter);
        }

        return text.split(SPLIT_CONDITION);
    }

    private static int calculate(String[] numbers) {
        return new Numbers(numbers).sum();
    }

}
