package common;

import lotto.exception.OutOfCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    private static final int NO_LIMIT = -1;

    private final int maxElements;

    protected List<NumberElement> elements;

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

    public void add(int number) {
        if(maxElements > NO_LIMIT && elements.size() == maxElements){
            throw new OutOfCountException();
        }

        elements.add(new NumberElement(number));
    }

    public int size() {
        return this.elements.size();
    }

    public boolean contains(int number) {
        return this.elements.contains(new NumberElement(number));
    }

    public boolean contains(NumberElement number) {
        return this.elements.contains(number);
    }

    /**
     * List 객체를 통해 생성하는 정적 메서드, 클래스 내부에서 반환값으로 생성할 때 사용
     * @param elements
     * @return
     */
    protected static NumberElementCollection of(List<NumberElement> elements) {
        NumberElementCollection collection = new NumberElementCollection();
        collection.elements = elements;
        return collection;
    }
}
