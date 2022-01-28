package stringcalculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiters {

    private List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public List<String> getDelimiters() {
        return delimiters.stream()
            .map(Delimiter::getDelimiter)
            .collect(Collectors.toList());
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
