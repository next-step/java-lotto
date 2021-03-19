package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            if (Arrays.stream(tokens).mapToInt(Integer::parseInt).anyMatch(n -> n < 0)) {
                throw new RuntimeException();
            }

            return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
        } else {
            final String[] tokens = text.split(",|:");

            if (Arrays.stream(tokens).mapToInt(Integer::parseInt).anyMatch(n -> n < 0)) {
                throw new RuntimeException();
            }

            return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
        }
    }
}
