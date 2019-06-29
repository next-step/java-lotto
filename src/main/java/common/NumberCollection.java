package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberCollection {

    protected List<NumberElement> elements;

    public NumberCollection(String[] source){
        this.elements = Arrays.stream(source)
                .map(NumberElement::new)
                .filter(number -> !number.isZero())
                .collect(Collectors.toList());
    }


    private NumberCollection() {
        this.elements = new ArrayList<>();
    }

    public NumberElement sum() {
        return elements.stream().reduce(new NumberElement(), (part, element) -> part.add(element));
    }

    /**
     * List 객체를 통해 생성하는 정적 메서드, 클래스 내부에서 반환값으로 생성할 때 사용
     * @param elements
     * @return
     */
    protected static NumberCollection of(List<NumberElement> elements) {
        NumberCollection collection = new NumberCollection();
        collection.elements = elements;
        return collection;
    }

}
