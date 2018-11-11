package raffle.lotto.win;

import raffle.lotto.Lotto;
import raffle.lotto.LottoNo;

public class WinningLotto {
    private Lotto lastWeekLotto;
    private LottoNo bonusLotto;

    public WinningLotto(Lotto lastWeekLotto) {
        this.lastWeekLotto = lastWeekLotto;
        this.bonusLotto = lastWeekLotto.getBounsLottoNo();
    }

    public WinLotto result(Lotto lotto) {
        return WinLotto.search(lotto.getWinCount(lastWeekLotto), lotto.hasBonus(bonusLotto));
    }
}
