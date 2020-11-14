import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DEFAULT_DELIMITER = "[,:]";
    private final static String PATTERN_CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return new Number(input).number();
        }

        return result(input);
    }

    private static int result(String input) {
        Matcher matcher = Pattern.compile(PATTERN_CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            return sumByCustomDelimiter(matcher);
        }

        return sum(input.split(DEFAULT_DELIMITER));
    }


    private static int sumByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] numbers = matcher.group(2).split(customDelimiter);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> new Number(n).number())
                .reduce(0, Integer::sum);
    }
}
