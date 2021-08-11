package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return elements;
    }


    @Override
    public String toString() {
        return "[" + String.join(", ", toStrings()) + "]" ;
    }

    private List<String> toStrings() {
        return elements.stream().map(String::valueOf).collect(Collectors.toList());
    }
}
