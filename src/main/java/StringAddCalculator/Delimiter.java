package StringAddCalculator;

import java.util.Arrays;
import java.util.Optional;

public enum Delimiter {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    Delimiter (String delimiter) {
        this.delimiter = delimiter;
    }

    public static Delimiter of(String value) {
        Optional<Delimiter> maybeDelimiter = Arrays.stream(values())
                .filter(o -> o.delimiter.equals(value))
                .findFirst();
       return maybeDelimiter.orElseThrow(RuntimeException::new);
    }

}
