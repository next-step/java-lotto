package step1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private final static String CUSTOM_DELIMITER_PATTERN_REGEX = "^//(.)\n(.*)";
    private final static String DEFAULT_DELIMITERS = ",|:";

    private final String value;

    public Delimiters() {
        this(DEFAULT_DELIMITERS);
    }

    public Delimiters(String value) {
        this.value = value;
    }

    public static boolean hasCustomDelimiter(String rawInput) {
        if (isBlank(rawInput)) {
            return false;
        }

        return rawInput.matches(CUSTOM_DELIMITER_PATTERN_REGEX);
    }

    public static String getCustomDelimiter(String rawInput) {
        if (isBlank(rawInput)) {
            return "";
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN_REGEX).matcher(rawInput);
        if (m.find()) {
            return m.group(1);
        }

        return "";
    }

    private static boolean isBlank(String rawInput) {
        return rawInput == null || rawInput.isEmpty();
    }

    public List<String> parse(String rawInput) {
        if (hasCustomDelimiter(rawInput)) {
            return Arrays.asList(removeCustomDelimiterPart(rawInput).split(this.value));
        }

        return Arrays.asList(rawInput.split(this.value));
    }

    private String removeCustomDelimiterPart(String rawInput) {
        return rawInput.split("\n")[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiters that = (Delimiters) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
