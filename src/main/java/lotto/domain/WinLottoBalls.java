package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;

public class WinLottoBalls {

    private final Lotto winLotto;
    private final LottoBall bonusBall;

    public WinLottoBalls(Lotto winLotto, LottoBall bonusBall) {
        this.winLotto = winLotto;
        this.bonusBall = bonusBall;
    }

    public LottoWinInfo countMatchWithBonus(Lotto lotto) {
        LottoWinInfo lottoWinInfo = lotto.countMatch(this.winLotto);

        return LottoWinInfo.valueOf(lottoWinInfo.getMatchedCount(), lotto.containNumber(bonusBall));
    }

    @Override
    public String toString() {
        return this.winLotto.toString();
    }
}
