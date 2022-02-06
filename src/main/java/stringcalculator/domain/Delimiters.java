package stringcalculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiters {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    private List<Delimiter> delimiters;

    public Delimiters(final String inputDelimiters) {
        final List<String> delimiters = getDelimiters(inputDelimiters);

        this.delimiters = delimiters.stream()
                .map(Delimiter::new)
                .collect(Collectors.toList());
    }

    private List<String> getDelimiters(final String inputDelimiters) {
        if (isBlank(inputDelimiters)) {
            return Arrays.asList(DEFAULT_DELIMITER_COLON, DEFAULT_DELIMITER_COMMA);
        }
        return Collections.singletonList(inputDelimiters);
    }

    private boolean isBlank(final String inputDelimiters) {
        return inputDelimiters.isEmpty();
    }

    public String getValuesToString() {
        return delimiters.stream()
                .map(Delimiter::getValue)
                .collect(Collectors.joining(""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiters that = (Delimiters) o;
        return Objects.equals(delimiters, that.delimiters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters);
    }
}
