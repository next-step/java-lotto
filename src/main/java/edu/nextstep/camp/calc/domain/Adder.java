package edu.nextstep.camp.calc.domain;

import java.util.Collection;

public class Adder {
    private static final int SUM_OF_EMPTY = 0;

    public static int add(Collection<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("invalid input: numbers must not be null");
        }

        if (numbers.isEmpty()) {
            return SUM_OF_EMPTY;
        }

        return numbers.stream()
                .reduce(Integer::sum)
                .get();
    }
}
