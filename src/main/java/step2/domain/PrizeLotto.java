package step2.domain;

public class PrizeLotto extends Lotto {

    public PrizeLotto(LottoNumber lottoNumber) {
        super(lottoNumber);
    }

    public int bonusNumber() {
        return this.bonusNumber;
    }

}
