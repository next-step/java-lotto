package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String SPLIT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_SPLIT_DELIMITER_REGEX = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (isSingleWord(text)) {
            return Integer.parseInt(text);
        }

        String[] tokens = split(text);
        List<Integer> tokensInt = parseInt(tokens);

        checkNegative(tokensInt);
        return sum(tokensInt);
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static boolean isSingleWord(String s) {
        return s.length() == 1;
    }

    private static List<Integer> parseInt(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Integer sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static void checkNegative(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < 0)
                .findAny()
                .ifPresent(t -> {throw new RuntimeException();});
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_SPLIT_DELIMITER_REGEX.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(SPLIT_DELIMITER_REGEX);
    }
}
