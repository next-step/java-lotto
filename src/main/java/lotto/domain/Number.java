package lotto.domain;

import common.StringResources;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;

    private final Set<Integer> numbers;

    public Number(List<Integer> numbers) {

        this.numbers = new HashSet<>(numbers);

        verifyNumbersCount();
        verifyWrongRangeNumber();

        Collections.unmodifiableSet(this.numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void verifyNumbersCount() {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(StringResources.ERR_DUPLICATE_NUMBER);
        }
    }

    private void verifyWrongRangeNumber() {
        if (numbers.stream().anyMatch(
                number -> number < LOTTO_MINIMUM_NUMBER ||
                number > LOTTO_MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_NUMBER);
        }
    }
}
