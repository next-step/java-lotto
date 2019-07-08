package lotto.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Csv {
    private static final String DELIMETER = ",";

    private List<String> csv;

    private Csv(List<String> csv) {
        this.csv = csv;
    }

    public static Csv of(List<String> strings) {
        return new Csv(strings);
    }

    public static Csv ofString(String string) {
        validateNull(string);
        return new Csv(Arrays.asList(string.split(DELIMETER)));
    }

    private static void validateNull(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }
    }

    public List<String> getCsv() {
        return Collections.unmodifiableList(csv);
    }

    public List<Long> getCsvLong() {
        return getCsv().stream().map(Long::parseLong).collect(Collectors.toList());
    }

    public String getString() {
        return String.join(",", csv);
    }
}
