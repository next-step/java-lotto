package com.kkambi.calculator.domain;

import java.util.Objects;

public class Element {

    private final String element;

    public Element(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element1 = (Element) o;
        return Objects.equals(element, element1.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
