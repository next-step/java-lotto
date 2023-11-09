package lotto.domain;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validSize(numbers);
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
}
