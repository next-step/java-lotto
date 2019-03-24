package lotto.domain;

import java.util.Set;

import static lotto.domain.ProfitFactory.profit;
import static lotto.domain.RankFactory.rank;

public class LotteryMachine {

    private Set<Integer> winnerLottery;


    public LotteryMachine(Set<Integer> lottery) {
        this.winnerLottery = lottery;

    }

    public int countProfit(Lottery lottery) {
        int rank = rankLottery(lottery);

        Profitable profitable = profit(rank);

        return profitable.profit(rank);
    }

    public int rankLottery (Lottery lottery) {

        int matchCount = lottery.matchLottery(this.winnerLottery);

        Rankable rankable = rank(matchCount);

        return rankable.rank(matchCount);
    }
}
