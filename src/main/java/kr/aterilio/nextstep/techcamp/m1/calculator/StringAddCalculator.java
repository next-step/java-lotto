package kr.aterilio.nextstep.techcamp.m1.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int RESULT_NONE = 0;
    private static final String EMPTY_STRING = "";
    private static final String REGEX_SPLIT_BY = ",|:";
    private static final String REGEX_CUSTOM_DELIMITER = "//(.)\\n";
    private static final String MSG_ERR_INPUT_NEGATIVE = "음수는 입력할 수 없습니다.";

    public static int splitAndSum(String formula) {
        if (empty(formula)) {
            return RESULT_NONE;
        }
        String[] units = splitString(formula);
        Integer[] numbers = convertToIntegers(units);
        return add(numbers);
    }

    private static boolean empty(String data) {
        return data == null || EMPTY_STRING.equals(data.trim());
    }

    private static String[] splitString(String formula) {
        String customDelimiter = customDelimiter(formula);
        if (!empty(customDelimiter)) {
            formula = formula.replaceAll(REGEX_CUSTOM_DELIMITER, EMPTY_STRING);
        }
        return formula.split(joinDelimiterRegEx(customDelimiter));
    }

    private static String customDelimiter(String formula) {
        Matcher matcher = Pattern.compile(REGEX_CUSTOM_DELIMITER)
                                 .matcher(formula);
        return extractDelimiter(matcher);
    }

    private static String extractDelimiter(Matcher matcher) {
        if (!matcher.find()) {
            return EMPTY_STRING;
        }
        return matcher.group(1);
    }

    private static String joinDelimiterRegEx(String customDelimiter) {
        if (empty(customDelimiter)) {
            return REGEX_SPLIT_BY;
        }
        return REGEX_SPLIT_BY + "|" + customDelimiter;
    }

    private static Integer[] convertToIntegers(String[] inputs) {
        Integer[] numbers = new Integer[inputs.length];
        for(int i = inputs.length-1; i >= 0; --i) {
            int number = Integer.parseInt(inputs[i]);
            validateNegative(number);
            numbers[i] = number;
        }
        return numbers;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(MSG_ERR_INPUT_NEGATIVE);
        }
    }

    private static int add(Integer[] split) {
        int result = 0;
        for (int unit : split) {
            result += unit;
        }
        return result;
    }
}
