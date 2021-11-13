package calculation;

import java.util.Arrays;
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

        return patternMatch(text).getNumber();
    }

    private static Number patternMatch(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        String[] numbers;
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = matcher.group(2).split(customDelimiter);

            return new Number(changeToIntegerArrayType(numbers));
        }

        numbers = text.split(SPLIT_CONDITION);
        return new Number(changeToIntegerArrayType(numbers));
    }

    private static int[] changeToIntegerArrayType(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
