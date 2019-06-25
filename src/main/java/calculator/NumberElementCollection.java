package calculator;

import java.util.List;

public class NumberElementCollection {

    String[] elements;

    public NumberElementCollection(String[] elements){
        this.elements = elements;
    }

    public int size() {
        return elements.length;
    }
}
