package Lotto.domain;

public class Lotto {
    private final LottoNumbers numbers;

    private Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final LottoNumbers numbers) {
        return new Lotto(numbers);
    }

    public LottoNumbers getNumbers() {
        return this.numbers;
    }

    public WinningType getWinningTypeWithWinningNumbers(final WinningLotto winningLotto) {
        return WinningType.valueOf(
                numbers.match(winningLotto.getWinningNumbers()),
                numbers.contains(winningLotto.getBonusNumber())
        );
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
