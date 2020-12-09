package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Delimiter {
    private static final String DEFAULT_PATTERN = "[,|:]";
    private static final String CUSTOM_PATTERN = "(//.\n).+";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\n";
    private static final String EMPTY = "";

    private final String delimiter;

    public Delimiter(String value) {
        this.delimiter = determineDelimiter(value);
    }

    private String determineDelimiter(String value) {
        if (!isStartWithCustomPattern(value)) {
            return DEFAULT_PATTERN;
        }

        return value.substring(0, value.indexOf(CUSTOM_DELIMITER_POSTFIX))
              .replaceAll(CUSTOM_DELIMITER_PREFIX, EMPTY);
    }

    public List<Number> numbers(String value) {
        String expression = getExpression(value);
        String[] split = expression.split(this.delimiter);

        return Stream.of(split)
              .map(Number::new)
              .collect(Collectors.toList());
    }

    private String getExpression(String value) {
        if (isStartWithCustomPattern(value)) {
            return value.substring(value.indexOf(CUSTOM_DELIMITER_POSTFIX) + 1);
        }

        return value;
    }

    private boolean isStartWithCustomPattern(String value) {
        return Pattern.matches(CUSTOM_PATTERN, value);
    }
}
