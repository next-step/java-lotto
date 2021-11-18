package edu.nextstep.camp.calc.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class PositiveNumbers implements Iterable<PositiveNumber> {
    private static final PositiveNumber SUM_OF_EMPTY = PositiveNumber.ofZero();

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

    @Override
    public Iterator<PositiveNumber> iterator() {
        return numbers.iterator();
    }

    public PositiveNumber sum() {
        return numbers.stream()
                .reduce(PositiveNumber::sum)
                .orElse(SUM_OF_EMPTY); // if empty
    }
}
