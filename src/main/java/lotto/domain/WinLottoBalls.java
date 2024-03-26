package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;

public class WinLottoBalls {

    private final Lotto winLotto;
    private final LottoBall bonusBall;

    public WinLottoBalls(Lotto winLotto, LottoBall bonusBall) {
        validateBonusNumber(winLotto, bonusBall);

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

    private void validateBonusNumber(Lotto winLotto, LottoBall bonusBall) {
        if (winLotto.containNumber(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호가 이미 당첨번호에 존재합니다.");
        }
    }
}
