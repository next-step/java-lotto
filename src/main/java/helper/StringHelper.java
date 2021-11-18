package helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public static List<String> splitByPattern(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }

        return Collections.emptyList();
    }

    public static List<String> splitByCommaOrColon(String input) {
        return Arrays.asList(input.split(",|:"));
    }

    public static int stringToInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private StringHelper() {
    }
}
