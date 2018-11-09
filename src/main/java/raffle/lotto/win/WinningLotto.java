package raffle.lotto.win;

import raffle.lotto.Lotto;

public class WinningLotto {
    private Lotto lastWeekLotto;
    private Lotto bonusLotto;

    public WinningLotto(Lotto lastWeekLotto, Lotto bonusLotto) {
        this.lastWeekLotto = lastWeekLotto;
        this.bonusLotto = bonusLotto;
    }

    public WinLotto result(Lotto lotto) {
        return WinLotto.search(lotto.getWinCount(lastWeekLotto), lotto.hasBonus(bonusLotto));
    }
}
