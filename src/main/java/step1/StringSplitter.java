package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By mand2 on 2020-11-16.
 */
public class StringSplitter {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String OR = "|";

    private static final Pattern BASIC_PATTERN = Pattern.compile("(,|:)");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringSplitter() {}

    public static String[] split(String input) {

        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.find()) {
            final String CUSTOM_SPLITTER = matcher.group(1);
            return matcher.group(2).split(COMMA + OR + COLON + OR + CUSTOM_SPLITTER);
        }

        return input.split(BASIC_PATTERN.pattern());
    }

}
