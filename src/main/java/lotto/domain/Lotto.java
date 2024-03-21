package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int NUMBER_LENGTH = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        assertNumbersLength(numbers);
        this.numbers = numbers;
    }

    private void assertNumbersLength(List<LottoNumber> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 필요합니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return this.numbers;
    }

}
