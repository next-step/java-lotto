package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.*;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSumResult(getSplittedResult(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return isNull(input) || input.isEmpty();
    }

    private static String[] getSplittedResult(String text) {
        String defaultSplitter = ",|:";

        Matcher matcher = Pattern.compile("//(.)\n(.*)")
                .matcher(text);
        if (matcher.find()) {
            return matcher.group(2)
                    .split(matcher.group(1));
        }
        return text.split(defaultSplitter);
    }

    private static int getSumResult(String[] input) {
        checkNumberFormatAndPositiveNumber(input);
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static void checkNumberFormatAndPositiveNumber(String[] values) {
        for (String value : values) {
            checkValue(value);
        }
    }

    private static void checkValue(String value) {
        int number = Integer.parseInt(value); // 숫자 검사
        if (number < 0) { // 음수 검사
            throw new RuntimeException("음수 입니다");
        }
    }
}
