package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionExpression {
    public static final String DEFAULT = "[,:]";
    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\n";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(
            CUSTOM_PREFIX + "(.*?)" + CUSTOM_SUFFIX);
    private final String input;
    private String separator = DEFAULT;

    public StringAdditionExpression(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            this.separator = matcher.group(1);
            input = input.replace(matcher.group(), "");
        }
        this.input = input;
    }

    public String[] array(){
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
