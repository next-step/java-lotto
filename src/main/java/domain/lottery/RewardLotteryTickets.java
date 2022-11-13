package domain.lottery;

import constant.Rank;

import java.util.ArrayList;
import java.util.List;


public class RewardLotteryTickets {
    private final List<Rank> ranks;
    private final List<Long> rewards;

    public RewardLotteryTickets(LotteryTickets lotteryTickets, WinnerLotteryTicket winnerLotteryTicket) {
        ranks = new ArrayList<>();
        rewards = new ArrayList<>();

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            ranks.add(winnerLotteryTicket.findRank(lotteryTicket));
            rewards.add(winnerLotteryTicket.findRank(lotteryTicket).findReward());
        }
    }

    public long countOfRank(int countOfMatchedNumber) {
        return ranks.stream().filter(rank -> rank == Rank.findRank(countOfMatchedNumber)).count();
    }

    public long sumAllRewards() {
        return rewards.stream().reduce(0L, Long::sum);
    }
}
