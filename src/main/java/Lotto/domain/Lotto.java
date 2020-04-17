package Lotto.domain;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public WinningType getWinningTypeWithWinningNumbers(final LottoNumbers winningNumbers) {
        return WinningType.valueOf(numbers.match(winningNumbers));
    }
}
