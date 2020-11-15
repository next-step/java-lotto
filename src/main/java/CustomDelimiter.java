import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomDelimiter {

    private static final String PATTERN_CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(PATTERN_CUSTOM_DELIMITER);
    private static final Matcher matcher = pattern.matcher("");

    public static boolean find(String input) {
        matcher.reset(input);
        return matcher.find();
    }

    public static int sum() {
        String customDelimiter = matcher.group(1);
        String[] numbers = matcher.group(2).split(customDelimiter);
        return CalculatorUtils.sum(numbers);
    }
}
