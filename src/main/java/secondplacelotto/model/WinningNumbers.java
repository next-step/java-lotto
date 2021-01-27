package secondplacelotto.model;

public class WinningNumbers {

    private Lotto lotto;

    private BonusNumber bonusNumber;

    public WinningNumbers(String stringWinningNumber, BonusNumber bonusNumber){
        this.lotto = new Lotto(stringWinningNumber.split(","));
        this.bonusNumber = bonusNumber;
    }

    public MatchingNumbers match(Lottos lottos) {
        return lottos.match(lotto, this.bonusNumber);
    }

}
