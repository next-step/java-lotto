package camp.nextstep.edu.lotto.domain;

public class WinningLottery {
    private final Lottery lottery;
    private final LotteryNumber bonusNumber;

    private WinningLottery(Lottery lottery, LotteryNumber bonusNumber) {
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        if (bonusNumber == null) {
            throw new IllegalArgumentException("'bonusNumber' must not be null");
        }
        if (lottery.hasBonus(bonusNumber)) {
            throw new IllegalArgumentException("'bonusNumber' must not be contained in numbers of winningLottery");
        }
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottery of(Lottery lottery, LotteryNumber bonusNumber) {
        return new WinningLottery(lottery, bonusNumber);
    }

    public RewardType resolveReward(Lottery lottery) {
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        int score = this.lottery.score(lottery);
        boolean hasBonus = lottery.hasBonus(bonusNumber);
        return RewardType.from(score, hasBonus);
    }
}
