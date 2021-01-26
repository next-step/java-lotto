package secondplacelotto.model;

public class BonusNumber {
    
    private final LottoNumber number;
    private boolean isBonusMatch = false;
    
    public BonusNumber(int number){
        this.number = new LottoNumber(number);
    }

    public void match(LottoNumber lottoNumber) {
        if (!isBonusMatch && number.equals(lottoNumber)) {
           isBonusMatch = true;
        }
    }

    public boolean getBonusStatus() {
        return this.isBonusMatch;
    }

}
