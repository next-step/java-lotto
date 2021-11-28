package com.kkambi.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(String[] elements) {
        this.numbers = Arrays.stream(elements)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private int parseNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
