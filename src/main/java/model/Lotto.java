package model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(final List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }
}
