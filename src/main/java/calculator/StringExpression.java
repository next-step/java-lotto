package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpression {
    private static final String REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";

    private final String delimiter;
    private final String items;

    private StringExpression(String delimiter, String items) {
        this.delimiter = delimiter;
        this.items = items;
    }

    public static StringExpression of(String source) {
        validateNull(source);
        return createIfExistDelimiter(source)
                .orElse(new StringExpression(DEFAULT_DELIMITER, source));
    }

    private static void validateNull(String source) {
        if (source == null) {
            throw new IllegalArgumentException("NULL 문자열은 허용되지 않습니다.");
        }
    }

    private static Optional<StringExpression> createIfExistDelimiter(String source) {
        Matcher matcher = Pattern.compile(REGEX).matcher(source);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String items = matcher.group(2);
            return Optional.of(new StringExpression(delimiter, items));
        }
        return Optional.empty();
    }

    public List<String> split() {
        return Arrays.asList(items.split(delimiter));
    }
}
