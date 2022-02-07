package lotto.domain;

public class BonusNumber {

    private final LottoNumber lottoNumber;

    public BonusNumber(final String number) {

        this.lottoNumber = new LottoNumber(number);
    }

    public LottoNumber get() {
        return lottoNumber;
    }
}
