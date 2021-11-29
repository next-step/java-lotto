package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final String INVALID_NUMBER = "0 이상의 정수값만 입력해주세요";

    public static int splitAndSum(String inputString) {
        if (isEmptyOrNullText(inputString)) {
            return ZERO;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(inputString);
        if (containsCustomDelimiter(matcher)) {
            String[] strings = customStrings(matcher);

            return sumCalculate(strings);
        }

        String[] text = inputString.split(DEFAULT_DELIMITER);
        return sumCalculate(text);
    }

    private static int sumCalculate(String[] strings) {
        int[] resultInteger = convertStringsToIntegers(strings);

        return IntStream.of(resultInteger).sum();
    }

    private static int[] convertStringsToIntegers(String[] strings) {
        return Arrays.stream(strings)
                .map(text -> convertStringToInt(text))
                .mapToInt(Integer::intValue).toArray();
    }

    private static int convertStringToInt(String text) {
        validParseOrElseThrow(text);

        return Integer.parseInt(text);
    }

    private static void validParseOrElseThrow(String text) {
        try {
            if (Integer.parseInt(text) < ZERO) {
                throw new InValidNumberException(INVALID_NUMBER);
            }
        } catch(NumberFormatException e) {
            throw new InValidNumberException(INVALID_NUMBER);
        }
    }

    private static boolean containsCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private static String[] customStrings(Matcher matcher) {
        String customDelimiter = matcher.group(FIRST);

        return matcher.group(SECOND).split(customDelimiter);
    }

    private static boolean isEmptyOrNullText(String text) {
        return (Objects.isNull(text) || text.trim().isEmpty());
    }
}
