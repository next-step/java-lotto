package com.kkambi.calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(Elements elements) {
        this.numbers = elements.getElements()
                .stream()
                .map(element -> new Number(element.getElement()))
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
