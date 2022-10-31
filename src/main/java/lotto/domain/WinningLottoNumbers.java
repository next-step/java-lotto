package lotto.domain;

public class WinningLottoNumbers {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber getBonusLottoNumber() {
        return this.bonusLottoNumber;
    }
}
