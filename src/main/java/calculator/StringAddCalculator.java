package calculator;

import calculator.util.NumberUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern customSeparatorPattern = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int splitAndSum(String input){
        if(isEmptyOrNull(input)) return 0;
        return sum(getSplitInput(input));
    }

    private static int sum(String[] splitInput) {
        if(containNegativeInt(splitInput)) {
            throw new RuntimeException("음수는 입력값에 포함되면 안됩니다.");
        }
        return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt).sum();
    }

    private static boolean containNegativeInt(String[] splitInput) {
        return Arrays.stream(splitInput).anyMatch(number -> NumberUtils.isNegativeInt(number));
    }

    private static String[] getSplitInput(String input) {
        Matcher m = customSeparatorPattern.matcher(input);
        if (m.find()) {
            String customSeparator = m.group(1);
            return m.group(2).split(customSeparator);
        }
        return input.split(DEFAULT_SEPARATOR);
    }

    private static boolean isEmptyOrNull(String input){
        return input == null || input.trim().isEmpty();
    }
}