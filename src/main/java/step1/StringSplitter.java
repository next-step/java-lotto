package step1;

import java.util.regex.Pattern;

/**
 * Created By mand2 on 2020-11-16.
 */
public class StringSplitter {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private static final Pattern BASIC_PATTERN = Pattern.compile("(,|:)");

    public StringSplitter() {}

    public static boolean hasBasicSplitter(String input) {
        return BASIC_PATTERN.matcher(input).find();
    }

    public static String[] split(String input) {
        return input.split(BASIC_PATTERN.pattern());
    }

}
