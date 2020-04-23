package Lotto.domain;

public class Lotto {
    private final LottoNumbers numbers;
    private final LottoType type;

    public Lotto(final LottoNumbers numbers, final LottoType type) {
        this.numbers = numbers;
        this.type = type;
    }

    public static Lotto newAutoLotto(final LottoNumbers numbers) {
        return new Lotto(numbers, LottoType.AUTO);
    }

    public static Lotto newManualLotto(final LottoNumbers numbers) {
        return new Lotto(numbers, LottoType.MANUAL);
    }

    public boolean isAutoLotto() {
        return this.type == LottoType.AUTO;
    }

    public boolean isManualLotto() {
        return this.type == LottoType.MANUAL;
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
