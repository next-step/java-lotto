package lotto;

import common.StringResources;

import java.util.Collections;
import java.util.List;

public class LottoNumber {

    public static final long LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(StringResources.ERR_DUPLICATE_NUMBER);
        }

        if (isWrongRangeNumber(numbers)) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_NUMBER);
        }

        this.numbers = numbers;
        Collections.sort(numbers);
        Collections.unmodifiableList(numbers);
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE;
    }

    private boolean isWrongRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_MINIMUM_NUMBER ||
                        number > LOTTO_MAXIMUM_NUMBER);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
