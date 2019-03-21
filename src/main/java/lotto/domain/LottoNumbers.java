package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int TOTAL_NUMBER_OF_THE_LOTTO = 6;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int MINIMUM_NUMBER = 1;
    private static final List<Integer> NUMBERS;

    private final List<Integer> values;

    static {
        NUMBERS = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .mapToObj(Integer::new)
                .collect(Collectors.toList())
        ;
    }

    public LottoNumbers(final List<Integer> values) {
        validate(values);
        Collections.sort(values);
        this.values = new ArrayList<>(values);
    }

    public static LottoNumbers randomNumbers() {
        Collections.shuffle(NUMBERS);
        return new LottoNumbers(NUMBERS.subList(0, TOTAL_NUMBER_OF_THE_LOTTO));
    }

    public List<Integer> get() {
        return new ArrayList<>(this.values);
    }

    long howManyMatches(final LottoNumbers winningNumber) {
        return this.values
                .stream()
                .filter(number -> winningNumber.values.contains(number))
                .count()
                ;
    }

    private void validate(final List<Integer> values) {
        checkTotalNumber(values);
        checkDuplicateNumbers(values);
        checkMaximumNumber(values);
        checkMinimumNumber(values);
    }

    private void checkTotalNumber(final List<Integer> values) {
        if (values.size() != TOTAL_NUMBER_OF_THE_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumbers(final List<Integer> values) {
        final long count = values.stream()
                .distinct()
                .count()
                ;
        if (count < values.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMaximumNumber(final List<Integer> values) {
        final Integer maximumNumber = values.stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new)
                ;
        if (maximumNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMinimumNumber(final List<Integer> values) {
        final int minimumNumber = values.stream()
                .min(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new)
                ;
        if (minimumNumber < MINIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
