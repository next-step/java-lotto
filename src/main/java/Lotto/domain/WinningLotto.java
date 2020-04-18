package Lotto.domain;

public class WinningLotto {
    private final LottoNumbers winningNumbers;

    private WinningLotto(final LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(final LottoNumbers winningNumbers) {
        return new WinningLotto(winningNumbers);
    }

    public static WinningLotto of(final String inputString) {
        return new WinningLotto(LottoNumbers.of(inputString));
    }

    public LottoNumbers getWinningNumbers() {
        return this.winningNumbers;
    }
}
