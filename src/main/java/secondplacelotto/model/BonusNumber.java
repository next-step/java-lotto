package secondplacelotto.model;

public class BonusNumber {
    
    private final LottoNumber number;
    private boolean matchingStatus = false;
    
    public BonusNumber(int number){
        this.number = new LottoNumber(number);
    }

    public void match(LottoNumber lottoNumber, int matchingCount) {
        matchingStatus = number.isMatchBonusNumber(lottoNumber,matchingCount);
    }

    public boolean isMatching() {
        return matchingStatus;
    }

    public void refreshMatchingStatus() {
        matchingStatus = false;
    }

}
