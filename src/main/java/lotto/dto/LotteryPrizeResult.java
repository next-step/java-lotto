package lotto.dto;

import lotto.domain.LotteryPrize;

public class LotteryPrizeResult {

    private int reward;

    private int matchingCount;

    public LotteryPrizeResult(LotteryPrize lotteryPrize, LotteryMatchResult lotteryMatchResult) {
        this.reward = lotteryPrize.getReward();
        this.matchingCount = lotteryMatchResult.getLotteryTicketListCountByMatchingCount(lotteryPrize.getMatchingCount());
    }

    public int getReward() {
        return reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getTotalReward() {
        return reward * matchingCount;
    }
}
