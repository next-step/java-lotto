package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Delimiter {

    private static final Pattern CUSTOM_PATTERN2 = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_PATTERN = "[,|:]";

    private final String delimiter;

    public Delimiter(String value) {
        this.delimiter = determineDelimiter(value);
    }

    private String determineDelimiter(String value) {
        Matcher matcher = getMatcher(value);
        if (matcher.matches()) {
            return matcher.group(1);
        }

        return DEFAULT_PATTERN;
    }

    public List<Number> numbers(String value) {
        String expression = getExpression(value);
        String[] split = expression.split(this.delimiter);

        return Stream.of(split)
              .map(Number::new)
              .collect(Collectors.toList());
    }

    private String getExpression(String value) {
        Matcher matcher = getMatcher(value);
        if (matcher.matches()) {
            return matcher.group(2);
        }

        return value;
    }

    private Matcher getMatcher(String value) {
        return CUSTOM_PATTERN2.matcher(value);
    }
}
