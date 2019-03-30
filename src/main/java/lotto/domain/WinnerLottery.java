package lotto.domain;

import java.util.Set;

public class WinnerLottery {
    private Lottery winnerLottery;
    private LotteryNo bonusBall;

    public WinnerLottery(Set<LotteryNo> winnerLottery, int bonusBall) {
        this.winnerLottery = new Lottery(winnerLottery);
        this.bonusBall = new LotteryNo(bonusBall);
    }

    public Ranking rankLottery (Lottery lottery) {
        return Ranking.getRank(lottery.matchLottery(this.winnerLottery), hasBonusNumber());
    }

    public boolean hasBonusNumber() {
        return winnerLottery.contain(this.bonusBall);
    }
}
