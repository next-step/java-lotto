package step1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMatcher {
    public static final String PATTERN = "//(.)\n(.*)";

    private TextMatcher() {}

    public static Matcher getMatcher(String text) {
        return Pattern.compile(PATTERN).matcher(text);
    }
}
