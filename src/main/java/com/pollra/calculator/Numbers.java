package com.pollra.calculator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * @since       2021.11.30
 * @author      pollra
 **********************************************************************************************************************/
public class Numbers {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sum() {
        Number tempNumber = numbers.get(ZERO);
        for (int i = ONE; i < numbers.size() - ONE; i++) {
            Number otherNumber = numbers.get(i);
            tempNumber = tempNumber.plus(otherNumber);
        }
        return tempNumber;
    }

    public static List<Number> toInstance(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Numbers)) return false;
        Numbers numbers1=(Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
