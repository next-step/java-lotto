package lotto.domain;

public class BonusNumber {

    private final LottoNumber lottoNumber;

    public BonusNumber(String lottoNumber) {
        this.lottoNumber = new LottoNumber(lottoNumber);
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
