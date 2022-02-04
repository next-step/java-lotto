package stringcalculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiters {

    private List<Delimiter> delimiters;

    public Delimiters(List<String> delimiters) {
        this.delimiters = delimiters.stream()
                .map(Delimiter::new)
                .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return delimiters.stream()
                .map(Delimiter::getValue)
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
