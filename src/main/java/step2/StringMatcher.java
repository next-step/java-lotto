package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatcher {

    public static final String DEFAULT_REGEX = ",|:";

    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;
    private static final Pattern pattern = Pattern.compile(CUSTOM_REGEX);

    private Matcher matcher;

    public StringMatcher(String text) {
        this.matcher = pattern.matcher(text);
    }


    public boolean find() {
        return matcher.find();
    }

    public String text() {
        return matcher.group(TEXT_GROUP);
    }

    public String delimiter() {
        return matcher.group(DELIMITER_GROUP);
    }
}
