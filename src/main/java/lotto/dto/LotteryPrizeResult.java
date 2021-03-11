package lotto.dto;

import lotto.domain.LotteryPrize;

public class LotteryPrizeResult {

    private int reward;

    private int matchingCount;

    private int matchedLotteryTicketCount;

    public LotteryPrizeResult(LotteryPrize lotteryPrize, LotteryMatchResult lotteryMatchResult) {
        this.reward = lotteryPrize.getReward();
        this.matchingCount = lotteryPrize.getMatchingCount();
        this.matchedLotteryTicketCount = lotteryMatchResult.getLotteryTicketListCountByMatchingCount(lotteryPrize.getMatchingCount());
    }

    public int getReward() {
        return reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getMatchedLotteryTicketCount() {
        return matchedLotteryTicketCount;
    }

    public int getTotalReward() {
        return reward * matchedLotteryTicketCount;
    }
}
