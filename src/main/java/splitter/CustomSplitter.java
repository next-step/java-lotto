package splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int INDEX_OF_VALUE = 2;
    private static final String[] EMPTY_ARRAY = new String[0];

    private final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public boolean isMatchedPattern(final String value) {
        return CUSTOM_PATTERN.matcher(value).find();
    }

    public String[] split(final String value) {
        if (value.isEmpty()) {
            return EMPTY_ARRAY;
        }
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(INDEX_OF_DELIMITER);
            return matcher.group(INDEX_OF_VALUE).split(customDelimiter);
        }
        return EMPTY_ARRAY;
    }
}
