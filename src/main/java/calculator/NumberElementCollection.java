package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    List<NumberElement> elements;

    public NumberElementCollection(String[] source){
        this.elements = Arrays.stream(source)
                .filter(this::isNotEmpty)
                .map(NumberElement::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return elements.size();
    }

    private boolean isNotEmpty(String value){
        return !value.trim().isEmpty();
    }

    public NumberElement sum() {
        return elements.stream().reduce(new NumberElement(), (part, element) -> part.add(element));
    }


}
