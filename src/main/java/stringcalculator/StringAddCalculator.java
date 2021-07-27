package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String DELIMITER = "[,:]";
    public static final String NOT_NUMERICAL = "숫자 이외의 값을 입력했습니다.";
    public static final String NEGATIVE_INTEGER = "음수값을 입력했습니다.";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        String[] tokens = split(text);
        List<Integer> numbers = mapToIntegers(tokens);
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> mapToIntegers(String[] tokens) {
        return Arrays.stream(tokens).map(StringAddCalculator::parseAndValidate)
                .collect(Collectors.toList());
    }

    private static int parseAndValidate(String token) {
        try {
            int number = Integer.parseInt(token);
            validate(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMERICAL);
        }
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_INTEGER);
        }
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
