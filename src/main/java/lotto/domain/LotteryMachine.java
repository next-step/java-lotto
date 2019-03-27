package lotto.domain;

import lotto.BonusBall;

import java.util.Set;

public class LotteryMachine {
    private Set<Integer> winnerLottery;
    private BonusBall bonusBall;

    public LotteryMachine(Set<Integer> lottery, int bonusNumber) {
        this.winnerLottery = lottery;
        this.bonusBall = new BonusBall(bonusNumber);
    }

    public int countProfit(Lottery lottery) {
        Ranking ranking = rankLottery(lottery);

        return ranking.getProfit();
    }

    public Ranking rankLottery (Lottery lottery) {
        return MatchingCount.getRank(lottery.matchLottery(this.winnerLottery), lottery.hasBonusNumber(this.bonusBall));
    }
}
