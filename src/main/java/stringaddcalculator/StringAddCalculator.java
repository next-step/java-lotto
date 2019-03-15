package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final String REGEX = ",|:";

    public static int add(String input) {
        if (isBlank(input))
            return 0;

        if (isSingleInteger(input)) {
            return Integer.parseInt(input);
        }

        return sum(convertStringsIntoIntegers(split(input, REGEX)));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isSingleInteger(String input) {
        return input.length() == 1 && isInteger(input);
    }

    private static Boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static String[] split(String tokens, String regex) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(tokens);
        if (matcher.find()) {
            return split(matcher.group(2), regex + "|" + matcher.group(1));
        }
        return tokens.split(regex);
    }

    private static List<Integer> convertStringsIntoIntegers(String[] tokens) {
        return Arrays.stream(tokens)
            .map(token -> {
                if (Integer.parseInt(token) < 0)
                    throw new RuntimeException();
                return Integer.parseInt(token);
            })
            .collect(Collectors.toList());
    }

    private static int sum(List<Integer> integerTokens) {
        return integerTokens.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
