import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author han
 */
public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);
        return sum(numbers);
    }

    private static boolean nullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String n : numbers) {
            result += Integer.parseInt(n);
        }
        return result;
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(",|:");
    }
}
