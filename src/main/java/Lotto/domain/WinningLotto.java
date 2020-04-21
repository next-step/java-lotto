package Lotto.domain;

public class WinningLotto {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public static WinningLotto of(final String inputString, final int bonusNumber) {
        return new WinningLotto(LottoNumbers.of(inputString), LottoNumber.from(bonusNumber));
    }

    public LottoNumbers getWinningNumbers() {
        return this.winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
