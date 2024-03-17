package lotto.domain;

import java.util.List;

public class LottoNumber {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final List<Integer> numbers;

    private LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumber from(List<Integer> numbers) {
        validLottoNumberSize(numbers);
        validLottoNumberBound(numbers);

        return new LottoNumber(numbers);
    }

    private static void validLottoNumberBound(List<Integer> numbers) {
        if (numbers.stream().anyMatch((number) -> number < MIN_LOTTO_NUMBER)) {
            throw new IllegalArgumentException();
        };
    }

    private static void validLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return numbers.size();
    }
}
