package model;

import java.util.List;

public class Lotto {

    private static final int MAX_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(final List<Integer> numbers) {
        if (numbers.size() > MAX_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }
}
