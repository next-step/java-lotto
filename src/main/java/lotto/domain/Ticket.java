package lotto.domain;

import common.StringResources;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ticket {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";

    private final Set<Integer> numbers;

    public Ticket(List<Integer> numbers) {

        this.numbers = new TreeSet<>(numbers);

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
        if (isOutOfRangeNumber()) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_NUMBER);
        }
    }

    private boolean isOutOfRangeNumber() {
        return numbers.stream().anyMatch(
                number -> number < LOTTO_MINIMUM_NUMBER ||
                        number > LOTTO_MAXIMUM_NUMBER);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, POSTFIX));
    }
}
