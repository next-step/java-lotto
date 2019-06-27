package model;

import lotto.exception.OutOfCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    private static final int NO_LIMIT = -1;

    private final int maxElements;

    private List<NumberElement> elements;

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

    private NumberElementCollection() {
        this.maxElements = NO_LIMIT;
        this.elements = new ArrayList<>();
    }

    public NumberElement sum() {
        return elements.stream().reduce(new NumberElement(), (part, element) -> part.add(element));
    }


    public boolean contains(int number) {
        return this.elements.contains(new NumberElement(number));
    }

    private boolean contains(NumberElement number) {
        return this.elements.contains(number);
    }

    public void add(int number) {
        if(maxElements > NO_LIMIT && elements.size() == maxElements){
            throw new OutOfCountException();
        }

        elements.add(new NumberElement(number));
    }

    public int size() {
        return this.elements.size();
    }

    /**
     * 대상 컬렉션과 일치하는 숫자만 포함하는 컬렉션 반환
     * @param collection
     * @return
     */
    public NumberElementCollection matchNumbers(NumberElementCollection collection) {
        List<NumberElement> matched = collection.elements.stream().filter(this::contains).collect(Collectors.toList());
        return NumberElementCollection.of(matched);
    }


    private static NumberElementCollection of(List<NumberElement> elements) {
        NumberElementCollection collection = new NumberElementCollection();
        collection.elements = elements;
        return collection;
    }
}
