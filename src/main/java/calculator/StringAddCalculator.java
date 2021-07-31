package calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String NORMAL_REGEX = "[,:]";
    private static final String CUSTOM_REGEX = "//(.)\n";
    private static final String OR = "|";
    private static final String BLANK = "";

    public int calculate(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] numbers = parse(input);

        negativeNumberCheck(numbers);

        return sum(numbers);
    }

    private void negativeNumberCheck(String[] numbers) {
        List<Integer> result = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .filter(number -> number < 0)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            throw new RuntimeException();
        }
    }

    private int sum(String[] numbers) {
        int result;
        result = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }

    private String[] parse(String input) {

        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(input);

        String customRegex = "";
        String result = input;
        while (m.find()) {
            String customDelimiter = m.group(1);
            customRegex += customDelimiter + OR;

            result = input.replaceAll(CUSTOM_REGEX, BLANK);
        }

        String splitRegex = customRegex + NORMAL_REGEX;

        return result.split(splitRegex);
    }
}
