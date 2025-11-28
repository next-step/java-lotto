package lottogame.model.lotto;

import java.util.Set;
import lottogame.model.winner.WinStandard;

public class WinningLottoNums {
    private final Lotto winLotto;
    private final LottoNum bonusNums;

    public WinningLottoNums(Set<LottoNum> winLottoNums, int bonusNums) {
        this(new Lotto(winLottoNums), new LottoNum(bonusNums));
    }

    public WinningLottoNums(Lotto winLotto, LottoNum bonusNums) {
        this.winLotto = winLotto;
        this.bonusNums = bonusNums;
    }

    public WinStandard checkIfWin(Lotto otherLotto) {
        int matchCount = this.winLotto.findMatchCountBy(otherLotto);
        boolean isMatchBonus = otherLotto.isContain(bonusNums);

        return WinStandard.findBy(matchCount, isMatchBonus);
    }
}
