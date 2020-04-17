package Lotto.domain;

public class Lotto {
    private final LottoNumbers numbers;

    private Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final LottoNumbers numbers) {
        return new Lotto(numbers);
    }

    public WinningType getWinningTypeWithWinningNumbers(final LottoNumbers winningNumbers) {
        return WinningType.valueOf(numbers.match(winningNumbers));
    }
}
