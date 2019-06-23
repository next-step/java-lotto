package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Elements {
    private List<Element> elements;

    Elements(List<Element> inputString) {
        this.elements = new ArrayList<>(inputString);
    }

    public static Elements from(String[] elementsFromInputString) {
        return new Elements(Arrays
                .stream(elementsFromInputString)
                .map(Element::from)
                .collect(Collectors.toList()));
    }

    public Element sum() {
        return elements.stream()
                .reduce(Element::add)
                .get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elements elements1 = (Elements) o;
        return Objects.equals(elements, elements1.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return "Elements{" +
                "elements=" + elements +
                '}';
    }
}
