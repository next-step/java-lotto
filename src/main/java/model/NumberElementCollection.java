package model;

import lotto.exception.OutOfCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    private static final int NO_LIMIT = -1;

    private final int maxElements;

    List<NumberElement> elements;

    public NumberElementCollection(String[] source){
        this.maxElements = NO_LIMIT;
        this.elements = Arrays.stream(source)
                .map(NumberElement::new)
                .filter(number -> !number.isZero())
                .collect(Collectors.toList());
    }

    public NumberElementCollection(int maxCount) {
        this.maxElements = maxCount;
        this.elements = new ArrayList<>();
    }

    public NumberElement sum() {
        return elements.stream().reduce(new NumberElement(), (part, element) -> part.add(element));
    }


    public boolean contains(int number) {
        return this.elements.contains(new NumberElement(number));
    }

    public void add(int number) {
        if(maxElements > NO_LIMIT && elements.size() == maxElements){
            throw new OutOfCountException();
        }

        elements.add(new NumberElement(number));
    }
}
