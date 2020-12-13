
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtils {

    private static final String REGEX_BASE = ",|:";
    public static final String REGEX_PATTERN = "//(.)\n(.*)";

    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);

    private SplitUtils() {
    }

    public static String[] split(String input) {
        return (isPattern(input))
            ? splitByPattern(input)
            : splitByBase(input);
    }

    private static boolean isPattern(String input) {
        return PATTERN.matcher(input).find();
    }

    private static String[] splitByPattern(String input) {
        Matcher matcher = PATTERN.matcher(input);
        matcher.find();
        String delimiter = matcher.group(1);
        String value = matcher.group(2);

        return value.split(delimiter);
    }

    private static String[] splitByBase(String input) {
        return input.split(REGEX_BASE);
    }

}
