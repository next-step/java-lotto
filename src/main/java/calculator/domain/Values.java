package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Values {
    private static final Pattern customPattern = Pattern.compile("//(.)\\n(.*)");
    private static final String DEFAULT_REGEX = ",|:";

    private final List<String> values;

    private Values(final List<String> values) {
        this.values = values;
    }

    public static Values init(final String input) {
        return new Values(toStrings(input));
    }

    private static List<String> toStrings(final String value) {
        Matcher matcher = customPattern.matcher(value);
        if (matcher.find()) {
            return customSplit(matcher);
        }
        return defaultSplit(value);
    }

    private static List<String> customSplit(final Matcher matcher) {
        return Arrays.asList(matcher.group(2).split(matcher.group(1)));
    }

    private static List<String> defaultSplit(final String value) {
        return Arrays.asList(value.split(DEFAULT_REGEX));
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(this.values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Values values1 = (Values) o;
        return Objects.equals(values, values1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
