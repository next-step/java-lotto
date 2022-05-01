package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Elements {
    Queue<Element> elements;

    Elements() {
        this(new LinkedList<>());
    }

    Elements(Queue<Element> elements) {
        this.elements = elements;
    }


    public static Elements of(String formula) {
        if (formula.isEmpty()) {
            throw new IllegalArgumentException("빈 수식은 입력이 불가능합니다");
        }

        List<String> elements = List.of(formula.split(" "));
        Elements es = new Elements();

        for (String element: elements) {
            es.elements.add(ElementBuilder.of(element));
        }

        return es;
    }

    public Element poll() {
        return elements.poll();
    }

    public boolean hasNextElements() {
        return !elements.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Elements elements = (Elements) obj;
        return this.elements.equals(elements.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
