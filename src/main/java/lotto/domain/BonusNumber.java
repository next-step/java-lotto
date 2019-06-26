package lotto.domain;

public class BonusNumber {
    private int bonusNumber;
    
    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    
    public LottoNumber getLottoNumber() {
        return new LottoNumber(bonusNumber);
    }
}
