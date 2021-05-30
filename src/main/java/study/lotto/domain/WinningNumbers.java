package study.lotto.domain;

public class WinningNumbers {
    LottoNumbers lottoNumbers;
    LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
