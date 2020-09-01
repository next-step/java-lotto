package one;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String PATTERN_EXPRESSION = "//(.)\n(.*)";

    private StringAddCalculator(){}

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile(PATTERN_EXPRESSION).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sum(tokens);
        }

        String[] numbers = text.split(",|:");
        return sum(numbers);

    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
            .map(StringAddCalculator::convert)
            .reduce(0, Integer::sum);
    }

    private static int convert(String s){
        int i = Integer.parseInt(s);
        if (i < 0) {
            throw new IllegalArgumentException("number cannot be negative value");
        }
        return i;
    }

}
