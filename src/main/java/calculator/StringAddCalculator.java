package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_KEYWORD = "[,:]";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        List<String> tokens = splitTokens(input);
        checkValidation(tokens);
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

    private static List<String> splitTokens(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }
        return Arrays.asList(input.split(SPLIT_KEYWORD));
    }

    private static void checkValidation(List<String> tokens) {
        tokens.stream()
                .filter(i -> Integer.parseInt(i) < 0)
                .findAny()
                .map(i -> {
                    throw new RuntimeException("0 이상의 숫자를 입력해주세요.");
                });
    }
}
