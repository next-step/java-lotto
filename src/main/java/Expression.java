import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {

    private static final String DEFAULT_DELIMITER = ",|:";

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static List<Integer> toArray(String expression) {
        if (isNullOrEmpty(expression)) {
            return new ArrayList<>();
        }

        String[] numbers = split(expression);
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(expression);
        if (matcher.find()) {
            return splitCustomDelimiter(matcher);
        }
        return expression.split(DEFAULT_DELIMITER);
    }

    private static String[] splitCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }

}
