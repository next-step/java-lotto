package step2.domain;

public class PrizeLotto extends Lotto {

    private LottoNumber bonusNumber;

    public PrizeLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int bonusNumber() {
        return this.bonusNumber.number();
    }

}
