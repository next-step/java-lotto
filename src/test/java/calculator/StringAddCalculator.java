package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String DEFAULT_NUMBER_DELIM = ",|:";

    private static final Pattern DELIM_AND_EXPR_PATTERN = Pattern.compile("//(.)?\n?(.+)");

    public static int splitAndSum(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        return new StringAddCalculator().calc(text);
    }

    private int calc(String text) {
        String delim = DEFAULT_NUMBER_DELIM;
        String expr = text;

        Matcher m = DELIM_AND_EXPR_PATTERN.matcher(text);
        if (m.find()) {
            delim = m.group(1);
            expr = m.group(2);
        }

        return new StringAddCalculator().sum(parseIntoIntegerList(delim, expr));
    }

    private List<Integer> parseIntoIntegerList(String delim, String expr) {
        return Arrays.stream(expr.split(delim))
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
    }

    public int sum(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new ArithmeticException("number should not be negative");
        }

        return numbers.stream()
                .reduce((a, b) -> a + b)
                .orElseThrow(() -> new ArithmeticException("invalid"));
    }

}
