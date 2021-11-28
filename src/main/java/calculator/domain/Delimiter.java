package calculator.domain;

import java.util.Objects;

public class Delimiter {

    public static final Delimiter DEFAULT_DELIMITER = new Delimiter(",|:");

    private final String value;

    private Delimiter(String value) {
        this.value = value;
    }

    public static Delimiter from(String value) {
        if (isNullOrEmpty(value)) {
            return DEFAULT_DELIMITER;
        }
        return new Delimiter(value);
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    public static boolean isDefaultDelimiter(Delimiter delimiter) {
        return delimiter.equals(DEFAULT_DELIMITER);
    }

    public String[] split(String token) {
        return token.split("\\" + value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(value, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
