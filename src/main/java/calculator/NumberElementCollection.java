package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberElementCollection {

    List<String> elements;

    public NumberElementCollection(String[] source){
        this.elements = Arrays.stream(source).filter(value -> !value.isEmpty()).collect(Collectors.toList());
    }

    public int size() {
        return elements.size();
    }
}
