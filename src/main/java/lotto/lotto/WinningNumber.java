package lotto.lotto;

import java.util.Set;

public class WinningNumber {
    private final Set<LottoNumber> numbers;

    public WinningNumber(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }
}