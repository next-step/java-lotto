package lottery.domain;

public class BonusBall {

    private final LotteryNumber bonusBall;

    public BonusBall(WinnerLottery winnerLottery, int number) {
        LotteryNumber bonusBall = new LotteryNumber(number);

        if (winnerLottery.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스볼은 당첨 번호와 포함되면 안됩니다. : " + bonusBall);
        }

        this.bonusBall = bonusBall;
    }

    public LotteryNumber bonusBall() {
        return bonusBall;
    }
}
