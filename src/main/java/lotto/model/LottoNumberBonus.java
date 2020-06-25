package lotto.model;

public class LottoNumberBonus {
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public LottoNumberBonus(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonus() {
        return bonusNumber;
    }
}
