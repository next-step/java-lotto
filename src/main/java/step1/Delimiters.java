package step1;

import java.util.List;
import java.util.Objects;

public class Delimiters {
    private final List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
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
