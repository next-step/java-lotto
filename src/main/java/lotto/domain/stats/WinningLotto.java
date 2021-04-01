package lotto.domain.stats;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoBall bonusBall;

    public WinningLotto(Lotto winningLotto, LottoBall bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public long getScoreIfMatchingBall(Lotto lotto) {
        return winningLotto.getMatchingBallCountFrom(lotto) * 2;
    }

    public long getScoreIfMatchingBonusBall(Lotto lotto) {
        return lotto.traverseCompareTo(bonusBall);
    }
}
