package edu.nextstep.camp.calc.domain;

import java.util.Collection;
import java.util.Collections;

public class PositiveNumbers {
    private static final PositiveNumber SUM_OF_EMPTY = PositiveNumber.ZERO;

    private final Collection<PositiveNumber> numbers;

    private PositiveNumbers(Collection<PositiveNumber> positiveNumbers) {
        numbers = Collections.unmodifiableCollection(positiveNumbers);
    }

    public static PositiveNumbers of(Collection<PositiveNumber> positiveNumbers) {
        if (positiveNumbers == null) {
            throw new IllegalArgumentException("invalid input: numbers must not be null");
        }

        return new PositiveNumbers(positiveNumbers);
    }


    public Collection<PositiveNumber> collect() {
        return numbers;
    }

    public PositiveNumber sum() {
        return numbers.stream()
                .reduce(PositiveNumber::add)
                .orElse(SUM_OF_EMPTY);
    }
}
