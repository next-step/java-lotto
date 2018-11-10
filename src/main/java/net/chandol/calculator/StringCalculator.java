package net.chandol.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;
import static java.util.Arrays.stream;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_PATTERN = "[,;]";


    public static Integer add(String input) {
        validateInput(input);
        List<Integer> numbers = toNumbers(split(input));
        return sum(numbers);
    }

    private static void validateInput(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException("빈 문자열은 허용하지 않음");
        }
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static List<Integer> toNumbers(String[] rawNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String rawNum : rawNumbers) {
            Integer number = getValidNumber(rawNum);
            numbers.add(number);
        }
        return numbers;
    }

    private static String[] split(String input) {
        String delimiter = DEFAULT_DELIMITER_PATTERN;
        if (hasCustomDelimiter(input)) {
            delimiter = getCustomDelimiter(input);
        }

        return getBody(input).split(delimiter);
    }

    private static Integer getValidNumber(String rawNum) {
        Integer number = Integer.valueOf(rawNum);
        if (number < 0) {
            throw new IllegalArgumentException("0보다 작으면 안되요!!");
        }
        return number;
    }

    private static String getBody(String input) {
        if (hasCustomDelimiter(input)) {
            return input.split("\\\\n")[1];
        }
        return input;
    }

    private static String getCustomDelimiter(String input) {
        String rawDelimiter = input.split("\\\\n")[0];
        String delimiter = rawDelimiter.replaceFirst("//", "");

        // "."에 대한 이슈 처리
        return Pattern.quote(delimiter);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

}
