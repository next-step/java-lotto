package study.calculator.argument;

import study.calculator.Delimiter;
import study.calculator.Number;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomArgument implements Argument{

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//[^0-9]{1}(\\n)$");
    private static final int MIN_LENGTH = 4;

    private final Delimiter delimiter;
    private final String body;

    public CustomArgument(String source) {
        this.delimiter = getCustomDelimiter(source);
        this.body = getBody(source);
    }

    public static boolean hasCustomArgument(String source) {
        if (source.length() < MIN_LENGTH) {
            return false;
        }

        // return source.startsWith("//") && source.charAt(3) == '\n';
        return CUSTOM_DELIMITER_PATTERN.matcher(source)
                .find();
    }

    private Delimiter getCustomDelimiter(String source) {
        return new Delimiter(String.valueOf(source.charAt(2)));
    }

    private String getBody(String source) {
        return source.substring(MIN_LENGTH, source.length());
    }

    @Override
    public List<Number> parseToNumber() {
        return delimiter.split(body)
                .stream()
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
