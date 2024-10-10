package calculator.model;


import calculator.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class NumberParsing {
    private static final String PARSING_ERROR_MESSAGE = "숫자형식이 아닙니다.";

    public static List<Integer> addNumber(String[] input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i += 2) {
            numbers.add(parse(input[i]));
        }

        return numbers;
    }

    private static boolean isNumber(String input) {
        return input.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static int parse(String input) {
        if (!isNumber(StringUtil.isEmpty(input))) {
            throw new NumberFormatException(PARSING_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }

}
