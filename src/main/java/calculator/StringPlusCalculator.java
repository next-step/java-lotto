package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringPlusCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX)
                                 .matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return sum(split(matcher.group(2), customDelimiter));
        }

        return sum(split(input, DEFAULT_DELIMITER_REGEX));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(String[] tokens) {
        return Stream.of(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] split(String input, String regex) {
        return input.split(regex);
    }
}
