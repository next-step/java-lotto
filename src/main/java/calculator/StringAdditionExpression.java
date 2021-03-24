package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionExpression implements Expression{
    public static final String DEFAULT = "[,:]";
    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\n";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(
            CUSTOM_PREFIX + "(.*?)" + CUSTOM_SUFFIX);
    public static final String ZERO = "0";
    private static final String EMPTY = "";
    private String input;
    private String separator;

    private StringAdditionExpression(String input) {
        this.input = input;
        this.separator = DEFAULT;
    }

    private StringAdditionExpression(String input, String separator) {
        this.input = input;
        this.separator = separator;
    }

    public static StringAdditionExpression getExpression(String input) {
        if (isNullOrEmpty(input)) {
            return new StringAdditionExpression(ZERO);
        }

        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (isDefault(matcher)) {
            return new StringAdditionExpression(input);
        }

        String excludeCustomPrefix = input.replace(matcher.group(), EMPTY);
        return new StringAdditionExpression(excludeCustomPrefix, matcher.group(1));
    }

    private static boolean isNullOrEmpty(String input) {
        return (input == null || EMPTY.equals(input));
    }

    private static boolean isDefault(Matcher matcher) {
        return !matcher.find();
    }

    public String[] array() {
        return input.split(separator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAdditionExpression that = (StringAdditionExpression) o;
        return input.equals(that.input) && separator.equals(that.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, separator);
    }
}
