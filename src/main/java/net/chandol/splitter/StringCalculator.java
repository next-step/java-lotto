package net.chandol.splitter;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER_PATTERN = "[,;]";


    public static Integer add(String input) {
        String delimiter = DEFAULT_DELIMITER_PATTERN;

        if (hasCustomDelimeter(input)) {
            delimiter = getCustomDelimiter(input);
            input = getBody(input);
        }

        List<Integer> numbers = new ArrayList<>();
        for (String rawNum : input.split(delimiter)) {
            Integer number = Integer.valueOf(rawNum);
            if (number < 0) {
                throw new IllegalArgumentException("0보다 작으면 안되요!!");
            }

            numbers.add(number);
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return sum;
    }

    private static String getBody(String input) {
        return input.split("\\\\n")[1];
    }

    private static String getCustomDelimiter(String input) {
        String rawDelimiter = input.split("\\\\n")[0];
        String delimiter = rawDelimiter.replaceFirst("//", "");

        // "."에 대한 이슈 처리
        return Pattern.quote(delimiter);
    }

    private static boolean hasCustomDelimeter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

}
