package lotto.domain;

import java.util.List;

public class LottoNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validSize(numbers);
        validNumbers(numbers);
        this.numbers = numbers;
    }

    private void validSize(List<Integer> numbers) {
        if(isSizeNotEqualsSix(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSizeNotEqualsSix(List<Integer> numbers) {
        return numbers == null || numbers.size() != 6;
    }

    private void validNumbers(List<Integer> numbers) {
        for(int number : numbers) {
            isNotInRange(number);
        }
    }

    private static void isNotInRange(int number) {
        if(number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException();
        }
    }

}
