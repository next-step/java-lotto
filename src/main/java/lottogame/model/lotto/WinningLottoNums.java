package lottogame.model.lotto;

import java.util.Set;
import lottogame.model.winner.WinStandard;

public class WinningLottoNums {
    private final Lotto winLotto;
    private final LottoNum bonusNums;

    public WinningLottoNums(Set<LottoNum> winLottoNums, LottoNum bonusNums) {
        this(new Lotto(winLottoNums), bonusNums);
    }

    public WinningLottoNums(Lotto winLotto, LottoNum bonusNums) {
        if (winLotto.isContain(bonusNums)) {
            throw new IllegalArgumentException("당첨번호와 보너스볼은 중첩될수 없습니다");
        }

        this.winLotto = winLotto;
        this.bonusNums = bonusNums;
    }

    public WinStandard checkIfWin(Lotto otherLotto) {
        int matchCount = this.winLotto.findMatchCountBy(otherLotto);
        boolean isMatchBonus = otherLotto.isContain(bonusNums);

        return WinStandard.findBy(matchCount, isMatchBonus);
    }
}
