package lotto.domain;

public class InputData {
    private Money money;
    private LottoNumber lottoNumber;

    public InputData(final Money money) {
        this.money = money;
    }

    public InputData(final LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Money money() {
        return this.money;
    }

    public LottoNumber lottoNumber() {
        return this.lottoNumber;
    }


}
