package lotto;

public class WinningNumbers {
    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int winningCount(LottoNumbers lottoNumbers) {
        return this.winningNumbers.matchCount(lottoNumbers);
    }

    public boolean isBonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
