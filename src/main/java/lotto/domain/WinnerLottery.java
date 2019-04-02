package lotto.domain;

public class WinnerLottery {
    private Lottery winnerLottery;
    private LotteryNo bonusBall;

    public WinnerLottery(Lottery winnerLottery, int bonusBall) {
        this.winnerLottery = winnerLottery;
        this.bonusBall = new LotteryNo(bonusBall);
    }

    public Ranking rankLottery (Lottery lottery) {
        return Ranking.getRank(lottery.matchLottery(this.winnerLottery), hasBonusNumber());
    }

    public boolean hasBonusNumber() {
        return winnerLottery.contain(this.bonusBall);
    }
}
