package step1.util;

import java.util.regex.Pattern;

public class PatternCache {
    private static class SingletonHelper{
        private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    }

    public static Pattern getCustomDelimiterPattern() {
        return SingletonHelper.CUSTOM_DELIMITER_PATTERN;
    }
}
