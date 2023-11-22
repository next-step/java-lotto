package autolotto.domain;

public class WinLotto {
    private final Lotto lastWeekWinNumber;
    private final LottoNo bonusNumber;

    public WinLotto(Lotto lastWeekWinNumber, LottoNo bonusNumber) {
        this.lastWeekWinNumber = lastWeekWinNumber;
        this.bonusNumber = bonusNumber;
        checkDuplicateBonusNumber();
    }
    public Lotto getLastWeekWinNumber(){
        return lastWeekWinNumber;
    }
    public LottoNo getBonusNumber(){
        return bonusNumber;
    }
    private void checkDuplicateBonusNumber(){
        if(this.lastWeekWinNumber.lottoNumbers().contains(this.bonusNumber)){
            throw new IllegalArgumentException("지난 주 당첨 로또 번호에 이미 보너스 번호가 있습니다.");
        };
    }
}
