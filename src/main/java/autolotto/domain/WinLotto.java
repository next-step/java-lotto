package autolotto.domain;

public class WinLotto {
    private final Lotto lastWeekWinNumber;
    private final int bonusNumber;

    public WinLotto(Lotto lastWeekWinNumber, int bonusNumber) {
        this.lastWeekWinNumber = lastWeekWinNumber;
        this.bonusNumber = bonusNumber;
    }
    public Lotto getLastWeekWinNumber(){
        return lastWeekWinNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
