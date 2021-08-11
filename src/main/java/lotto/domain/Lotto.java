package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> elements;

    public Lotto(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(elements, lotto.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
