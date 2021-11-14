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

        int[] numbers = changeToIntegerArrayType(patternMatch(text));

        return calculate(numbers);
    }

    private static String[] patternMatch(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            return matcher.group(2).split(customDelimiter);
        }

        return text.split(SPLIT_CONDITION);
    }

    private static int[] changeToIntegerArrayType(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int calculate(int[] numbers) {
        Number number = new Number(numbers);
        int loopNumber = numbers.length - 1;
        for (int i = 0; i < loopNumber; i++) {
            number.plus(numbers[i + 1]);
        }

        return number.getNumber();
    }

}
