package lotto;

public class BonusNumber {
    private LottoNumber bonusNumber;

    public BonusNumber(int bonusNumber){
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoNumber.equals(bonusNumber);
    }
}
