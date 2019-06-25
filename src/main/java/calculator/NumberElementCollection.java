package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    List<NumberElement> elements;

    public NumberElementCollection(String[] source){
        this.elements = Arrays.stream(source)
                .map(NumberElement::new)
                .filter(number -> !number.isZero())
                .collect(Collectors.toList());
    }

    public NumberElement sum() {
        return elements.stream().reduce(new NumberElement(), (part, element) -> part.add(element));
    }


}
