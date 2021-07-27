package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_KEYWORD = ",|:";

    public static int splitAndSum(String input) {
        List<String> tokens = Arrays.asList(input.split(SPLIT_KEYWORD));

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }
}
