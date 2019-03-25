package lotto.domain;

import java.util.Set;

public class LotteryMachine {
    private static final int MINIMUM_MATCH_LOTTO = 3;
    private static final int ZERO = 0;
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
        MatchingCount matchingCount;

        if(count < MINIMUM_MATCH_LOTTO) {
            matchingCount = MatchingCount.valueOf(ZERO);
            return matchingCount.getRank();
        }

        matchingCount = MatchingCount.valueOf(count);
        return matchingCount.getRank();
    }
}
