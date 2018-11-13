package raffle.lotto.win;

import raffle.lotto.Lotto;
import raffle.lotto.LottoNo;

import java.util.List;

public class WinningLotto {
    private List<LottoNo> lastWeekLotto;
    private LottoNo bonusLotto;

    public WinningLotto(List<LottoNo> lastWeekLotto, LottoNo bonusLotto) {
        this.lastWeekLotto = lastWeekLotto;
        this.bonusLotto = bonusLotto;
    }

    public WinLotto result(Lotto lotto) {
        return WinLotto.search(lotto.getWinCount(lastWeekLotto), lotto.hasBonus(bonusLotto));
    }
}
