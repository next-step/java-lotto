package step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private static final String DEFAULT_DELIMITER = ":|,";
    private static final String ADD_FORMAT = "%s|%s";

    private final String delimiter;

    private Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter withDefaultDelimiter() {
        return new Delimiter(DEFAULT_DELIMITER);
    }

    public static Delimiter custom(String delimiter) {
        return new Delimiter(delimiter);
    }

    public static Delimiter customByPattern(String input, Pattern custom_pattern) {
        String delimiter = "";
        Matcher matcher = custom_pattern.matcher(input);
        if(matcher.find()) {
            delimiter = matcher.group(1);
        }
        return new Delimiter(delimiter);
    }

    public Delimiter addDelimiter(Delimiter target) {
        return new Delimiter(String.format(ADD_FORMAT, this.delimiter, target.delimiter));
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public boolean isExist() {
        return this.delimiter != null || !this.delimiter.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
