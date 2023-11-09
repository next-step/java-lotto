package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (isSizeNotEqualsSix(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSizeNotEqualsSix(List<Integer> numbers) {
        return numbers == null || numbers.size() != 6;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            isNotInRange(number);
        }
    }

    private static void isNotInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

}
