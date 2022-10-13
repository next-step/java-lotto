package lotto;

import java.util.List;

import lotto.model.LottoReward;

public class LottoYield {
    private final int paymentAmount;
    private final int rewardAmount;

    public LottoYield(int paymentAmount, int rewardAmount) {
        this.paymentAmount = paymentAmount;
        this.rewardAmount = rewardAmount;
    }

    public LottoYield(int paymentAmount, List<LottoMatchResult> matchResults) {
        this.paymentAmount = paymentAmount;
        this.rewardAmount = matchResults.stream().map(LottoMatchResult::getLottoReward).map(LottoReward::getRewardAmount).reduce(Integer::sum).orElseGet(() -> 0);
    }

    public double calculate() {
        return Math.floor(((double) rewardAmount / paymentAmount) * 100) / 100;
    }
}
