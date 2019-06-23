package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
