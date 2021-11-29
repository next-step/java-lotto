package com.kkambi.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Elements {

    private final List<Element> elements;

    public Elements(String[] split) {
        this.elements = Arrays.stream(split)
                .map(Element::new)
                .collect(Collectors.toList());
    }

    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
