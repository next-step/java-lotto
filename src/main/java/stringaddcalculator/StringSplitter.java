package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String REGEX_FOR_DEFAULT = ",|:";
    private static final String REGEX_FOR_CUSTOM = "//(.)@(.*)";

    public static List<String> split(String input) {
        return splitByCustom(input);
    }

    private static List<String> splitByCustom(String input) {
        Matcher m = Pattern.compile(REGEX_FOR_CUSTOM).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return splitByDefault(input);
    }

    private static List<String> splitByDefault(String input) {
        return Arrays.asList(input.split(REGEX_FOR_DEFAULT));
    }
}