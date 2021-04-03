package lotto.domain.stats;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.prize.Prize;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoBall bonusBall;

    public WinningLotto(Lotto winningLotto, LottoBall bonusBall) {
        if (winningLotto.traverseCompareTo(bonusBall) > 0) {
            throw new IllegalArgumentException("보너스볼은 중복되지 않아야 합니다.");
        }
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public long getScoreIfMatchingBall(Lotto lotto) {
        long matchingBallCount = winningLotto.getMatchingBallCountFrom(lotto);
        long score = matchingBallCount * 2;
        if (matchingBallCount == Prize.SECOND.getMatchingBallCount()) {
            score += getScoreIfMatchingBonusBall(lotto);
        }
        return score;
    }

    private long getScoreIfMatchingBonusBall(Lotto lotto) {
        return lotto.traverseCompareTo(bonusBall);
    }
}
