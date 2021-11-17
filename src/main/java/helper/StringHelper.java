package helper;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author han
 */
public class StringHelper {

    public static boolean nullOrEmpty(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    public static String[] splitByPattern(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return splitByCommaOrColon(input);
    }

    public static String[] splitByCommaOrColon(String input) {
        return input.split(",|:");
    }

    private StringHelper() {
    }
}
