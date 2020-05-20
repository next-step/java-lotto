package com.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculatorElement {

    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "문자열 계산기에 음수는 포함될 수 없습니다.";
    private List<Integer> elements;

    public CalculatorElement() {
        this.elements = new ArrayList<>();
    }

    public void convertElements(List<String> originalElements) {
        for (String originalElement : originalElements) {
            Integer convertedElement = convertEachElement(originalElement);
            this.elements.add(convertedElement);
        }
    }

    private Integer convertEachElement(String originalElement) {
        try {
            return Integer.valueOf(originalElement);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public void validateElements() {
        for (Integer element : this.elements) {
            validateEachElement(element);
        }
    }

    private void validateEachElement(Integer element) {
        if (element < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Integer addAllElements() {
        return this.elements.stream()
                .reduce(0, Integer::sum);
    }
}
