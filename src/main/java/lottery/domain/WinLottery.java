package lottery.domain;

import java.util.List;

public class WinLottery {
    private final Lottery lottery;
    private final BonusBall bonusBall;

    public WinLottery(Lottery lottery, BonusBall bonusBall) {
        this.lottery = lottery;
        this.bonusBall = bonusBall;
    }

    public List<LotteryNumber> numbers() {
        return lottery.numbers();
    }

    public BonusBall bonusBall() {
        return bonusBall;
    }
}
