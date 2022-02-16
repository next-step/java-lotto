package lotto.domain;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public boolean isWinningNumbersContain(LottoNumber number) {
        return number.isInLottoNumberList(winningNumbers.getLotto());
    }

    public boolean isBonusNumberEqualTo(LottoNumber number) {
        return number.isEqualTo(bonusNumber);
    }
}
