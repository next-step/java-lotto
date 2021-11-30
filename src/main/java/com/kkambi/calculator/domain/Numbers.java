package com.kkambi.calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<String> elements) {
        this.numbers = elements.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
