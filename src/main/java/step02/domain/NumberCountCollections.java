package step02.domain;

import java.util.List;
import java.util.Objects;

public class NumberCountCollections {
    private final List<NumberCount> numbersCount;

    private NumberCountCollections(List<NumberCount> numberCounts) {
        this.numbersCount = numberCounts;
    }

    public static NumberCountCollections of(List<NumberCount> numberCounts) {
        return new NumberCountCollections(numberCounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCountCollections that = (NumberCountCollections) o;
        return Objects.equals(numbersCount, that.numbersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersCount);
    }
}
