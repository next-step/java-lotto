package com.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculatorElement {

    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "문자열 계산기에 음수는 포함될 수 없습니다.";
    private List<Integer> elements;

    public CalculatorElement() {
        this.elements = new ArrayList<>();
    }

    public void validateElements(List<String> originalElements) {
        for (String originalElement : originalElements) {
            Integer convertedElement = convertStrToIntWithEachElement(originalElement);
            checkNegativeElement(convertedElement);
            this.elements.add(convertedElement);
        }
    }

    private Integer convertStrToIntWithEachElement(String originalElement) {
        try {
            return Integer.valueOf(originalElement);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private void checkNegativeElement(Integer element) {
        if (element < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Integer addAllElements() {
        return this.elements.stream()
                .reduce(0, Integer::sum);
    }
}
