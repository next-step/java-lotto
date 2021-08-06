package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int SEPARATOR_GROUP_NUMBER = 1;
    private static final int EXPRESSION_GROUP_NUMBER = 2;

    public static int[] parser(String s) {
        Matcher matcher = CUSTOM_PATTERN.matcher(s);
        if (matcher.find()) {
            String delimiter = String.join("|", DELIMITER, matcher.group(SEPARATOR_GROUP_NUMBER));
            return split(matcher.group(EXPRESSION_GROUP_NUMBER), delimiter);
        }

        return Arrays.stream(s.split(DELIMITER)).
                mapToInt(Integer::parseInt).
                toArray();
    }

    private static int[] split(String s, String delimiter) {
        return Arrays.stream(s.split(delimiter))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
