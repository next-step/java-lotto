package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static SummoryValue splitAndSum(String input) {
        if (isEmptyOrNull(input)) {
            return new SummoryValue();
        }
        String[] splitValue = split(input);
        return sum(splitValue);
    }

    private static SummoryValue sum(String[] splitValue) {
        Arrays.stream(splitValue).forEach(StringAddCalculator::negativeExists);
        Integer result = Arrays.stream(splitValue)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
        return new SummoryValue(result);
    }

    private static void negativeExists(String splitedValue) {
        if (splitedValue.indexOf(Constant.NEGATIVE_OPERATOR) == 0) {
            throw new RuntimeException();
        }
    }

    private static String[] split(String input) {
        return Separator.getSeparateType(input).execute(input);
    }


    private static boolean isEmptyOrNull(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
