package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

import static step1.Constant.CUSTOM_SEPARATE_REGEX;
import static step1.Constant.DEFAULT_SPLIT_REGEX;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isEmptyOrNull(input)) {
            return 0;
        }
        String[] splitValue = split(input);
        return sum(splitValue);
    }

    private static int sum(String[] splitValue) {
        Arrays.stream(splitValue).forEach(StringAddCalculator::negativeExists);
        return Arrays.stream(splitValue)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
    }

    private static void negativeExists(String splitedValue) {
        if (splitedValue.indexOf(Constant.NEGATIVE_OPERATOR) == 0) {
            throw new RuntimeException();
        }
    }

    private static String[] split(String input) {
        return getSeparateType(input).execute(input);
    }

    private static Separator getSeparateType(String input) {
        if (isMatchPattern(DEFAULT_SPLIT_REGEX, input)) {
            return Separator.DEFAULT;
        }
        if (isMatchPattern(CUSTOM_SEPARATE_REGEX, input)) {
            return Separator.CUSTOM;
        }
        return Separator.NONE;
    }

    private static boolean isMatchPattern(String pattern, String input) {
        return Pattern.compile(pattern).matcher(input).find();
    }

    private static boolean isEmptyOrNull(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
