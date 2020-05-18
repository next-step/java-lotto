package splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int INDEX_OF_VALUE = 2;
    private static final List<String> REGEX_META_CHAR = new ArrayList<>(
            Arrays.asList(".", "|", "^", "$", "*", "+", "?", "(", "[", "{", ")")
    );

    private final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public boolean isMatchedPattern(final String value) {
        return CUSTOM_PATTERN.matcher(value).find();
    }

    @Override
    public String[] split(final String value) {
        if (value.isEmpty()) {
            return EMPTY_ARRAY;
        }
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = this.convertEscapedString(matcher.group(INDEX_OF_DELIMITER));
            return matcher.group(INDEX_OF_VALUE).split(customDelimiter);
        }
        return EMPTY_ARRAY;
    }

    private String convertEscapedString(final String customDelimiter) {
        if (REGEX_META_CHAR.contains(customDelimiter)) {
            return "\\" + customDelimiter;
        }
        return customDelimiter;
    }
}
