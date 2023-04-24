package lotto.domain.winning;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.rating.WinningRatingType;

import java.util.Map;

public class WinningStat {
    private final Map<WinningRatingType, WinningCount> winningCount;
    private final Reward reward;

    public WinningStat() {
        this.winningCount = WinningRatingType.toWinningCount();
        this.reward = new Reward();
    }

    public void judgeWinning(Lotto lotto, WinningBall winningBall) {
        final WinningRatingType winningRatingType = WinningRatingType.findBy(winningBall.statCount(lotto), winningBall.isBonusBall(lotto));

        this.count(winningRatingType);
        this.plusReward(winningRatingType);
    }

    private void count(WinningRatingType type) {
        this.winningCount.get(type).plusCount();
    }

    private void plusReward(WinningRatingType type) {
        this.reward.plusReward(type);
    }

    public float rateOfReturn(Amount amount) {
        return this.reward.rateOfReturn(amount);
    }

    public int getWinningCount(WinningRatingType type) {
        return this.winningCount.get(type).getCount();
    }
}
