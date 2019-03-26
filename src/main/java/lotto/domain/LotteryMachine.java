package lotto.domain;

import java.util.Set;

public class LotteryMachine {

    private Set<Integer> winnerLottery;

    public LotteryMachine(Set<Integer> lottery) {
        this.winnerLottery = lottery;
    }

    public int countProfit(Lottery lottery) {
        Ranking ranking = rankLottery(lottery);

        return ranking.getProfit();
    }

    public Ranking rankLottery (Lottery lottery) {
        int count = lottery.matchLottery(this.winnerLottery);
        return MatchingCount.getRank(count);
    }
}
