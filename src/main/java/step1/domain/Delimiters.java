package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiters {
    private static final String[] BASE_DELIMITERS = {",", ":"};

    private final List<Delimiter> delimiters;

    public static Delimiters createWithoutInput() {
        return new Delimiters(Arrays.stream(BASE_DELIMITERS)
                .map(d -> new Delimiter(d))
                .collect(Collectors.toList()));
    }

    public static Delimiters createWithInput(Delimiter delimiter) {
        return new Delimiters(new ArrayList() {{
            add(delimiter);
        }});
    }

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public String joining() {
        return this.delimiters.stream()
                .map(d -> d.getDelimiter())
                .collect(Collectors.joining("|"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiters that = (Delimiters) o;
        return Objects.equals(delimiters, that.delimiters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters);
    }
}
