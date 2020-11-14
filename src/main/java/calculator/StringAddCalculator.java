package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String NEGATIVE_NUMERIC_ERROR_MESSAGE = "오류:: 음수값은 계산 할 수 없습니다";
    private static final String REGEX_REMOVE_SPECIAL_CHARACTERS = "(?:[^0-9,-])+";
    private static final String REGEX_LEADING_NUMBER = "^[^0-9-]+";
    private static final String REGEX_TRAILING_NUMBER = "^[^0-9-]+$";
    private static final String SEPARATOR = ",";

    public static int splitAndSum(String input) {
        if(isEmpty(input)) {
            return 0;
        }
        int[] ints = parseIntArray(getStringSplit(input));
        return Arrays.stream(ints).sum();
    }

    private static boolean isEmpty(String input) {
        return StringValidator.check(input) == 0;
    }

    private static String replaceAllString(String input) {
        String result = input.replaceAll(REGEX_REMOVE_SPECIAL_CHARACTERS,SEPARATOR);
        return removeNonNumeric(result);
    }

    private static String removeNonNumeric(String result) {
        result = result.replaceAll(REGEX_LEADING_NUMBER,"");
        return result.replaceAll(REGEX_TRAILING_NUMBER,"");
    }

    private static String[] getStringSplit(String input) {
        return replaceAllString(input).split(SEPARATOR);
    }

    private static int[] parseIntArray(String[] strings) {
        checkNegativeNumber(strings);
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void throwRuntimeException(boolean result) {
        if(result)
            throw new RuntimeException(NEGATIVE_NUMERIC_ERROR_MESSAGE);
    }

    private static void checkNegativeNumber(String[] strings) {
        throwRuntimeException(Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < 0)
                .count() != 0);
    }
}
