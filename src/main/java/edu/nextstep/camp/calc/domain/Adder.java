package edu.nextstep.camp.calc.domain;

import java.util.Collection;

public class Adder {
    private static final PositiveNumber SUM_OF_EMPTY = PositiveNumber.ofZero();

    public static PositiveNumber add(Collection<PositiveNumber> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("invalid input: numbers must not be null");
        }

        return numbers.stream()
                .reduce(PositiveNumber::sum)
                .orElse(SUM_OF_EMPTY); // if empty
    }
}
