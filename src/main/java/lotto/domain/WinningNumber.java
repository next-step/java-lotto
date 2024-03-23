package lotto.domain;

public class WinningNumber {
    private final LottoNumbers winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int containsCount(LottoNumbers lottoNumbers) {
        return this.winningNumber.containsCount(lottoNumbers);
    }

    public boolean isContainBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.isContainNumber(bonusNumber);
    }
}
