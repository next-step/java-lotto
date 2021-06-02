package study.lotto.domain;

public class WinningNumbers {
    Lotto lotto;
    LottoNumber bonusNumber;

    public WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lottoNumbers() {
        return lotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
