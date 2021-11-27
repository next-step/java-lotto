package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiters {
    private static final List<Delimiter> BASE_DELIMITERS = new ArrayList(){{
        new Delimiter(",");
        new Delimiter(":");
    }};

    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiters createWithoutDelimiter() {
        return new Delimiters(BASE_DELIMITERS);
    }

    public static Delimiters createWithDelimiter(Delimiter delimiter) {
        return new Delimiters(new ArrayList(){{
            add(delimiter);
        }});
    }

    public InputNumbers split(String s) {
        String joining = delimiters.stream()
                .map(d -> d.getDelimiter())
                .collect(Collectors.joining("|"));

        return new InputNumbers(Arrays.stream(s.split(joining))
                .map(i -> new InputNumber(Integer.parseInt(i)))
                .collect(Collectors.toList()));
    }

    // TODO 특수문자 체크

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
