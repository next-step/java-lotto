package raffle.lotto.win;

import raffle.lotto.Lotto;

public class WinningLotto {
    private Lotto lastWeekLotto;
    private int bonusLotto;

    public WinningLotto(Lotto lastWeekLotto, int bonusLotto) {
        this.lastWeekLotto = lastWeekLotto;
        this.bonusLotto = bonusLotto;
    }

    public WinLotto result(Lotto lotto) {
        return WinLotto.search(lotto.getWinCount(lastWeekLotto), lotto.hasBonus(bonusLotto));
    }
}
