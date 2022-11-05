package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumbers numbers;

    public WinningNumbers(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public WinningNumbers(List<Integer> numbers) {
        this(LottoNumbers.of(numbers));
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers.getNumbers();
    }
}
