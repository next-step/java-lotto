package lotto.domain;

public class WinningNumber {
    private final LottoNumber winningNumber;
    private final MyNumber bonusNumber;

    public WinningNumber(LottoNumber winningNumber, MyNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int containsCount(LottoNumber lottoNumber) {
        return this.winningNumber.containsCount(lottoNumber);
    }

    public boolean isContainBonusNumber(LottoNumber lottoNumber) {
        return lottoNumber.isContainNumber(bonusNumber);
    }
}
