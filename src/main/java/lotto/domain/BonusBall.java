package lotto.domain;

public class BonusBall {
    private LotteryNo bonusNumber;

    public BonusBall(int bonusNumber) {
        this.bonusNumber = new LotteryNo(bonusNumber);
    }

    public void checkBonusBallValidation(Lottery winnerLottery) {
        if (winnerLottery.contain(this.bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
