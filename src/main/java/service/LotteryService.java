package service;

import domain.lottery.*;

public class LotteryService {
    public long countOfLotteryWinners(int countOfMatchedNumber, RewardLotteryTickets rewardLotteryTickets) {
        return rewardLotteryTickets.countOfRank(countOfMatchedNumber);
    }

    public long findTotalRewards(RewardLotteryTickets rewardLotteryTickets) {
        return rewardLotteryTickets.sumAllRewards();
    }
}
