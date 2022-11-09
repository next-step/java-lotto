package domain.lottery;

import constant.Rank;

import java.util.ArrayList;
import java.util.List;

import static constant.LotteryRules.*;

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
        switch (countOfMatchedNumber) {
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FOURTH_PLACE:
                return ranks.stream().filter(rank -> rank == Rank.FOURTH).count();
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_THIRD_PLACE:
                return ranks.stream().filter(rank -> rank == Rank.THIRD).count();
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_PLACE:
                return ranks.stream().filter(rank -> rank == Rank.SECOND).count();
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_SECOND_WITH_BONUS_PLACE:
                return ranks.stream().filter(rank -> rank == Rank.SECOND_WITH_BONUS).count();
            case NUMBER_OF_MATCHED_TICKET_NUMBER_FOR_FIRST_PLACE:
                return ranks.stream().filter(rank -> rank == Rank.FIRST).count();
            default:
                return ranks.stream().filter(rank -> rank == Rank.UNKNOWN).count();
        }
    }

    public long sumAllRewards() {
        return rewards.stream().reduce(0L, Long::sum);
    }
}
