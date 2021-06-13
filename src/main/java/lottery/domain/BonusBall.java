package lottery.domain;

public class BonusBall {

    private final LotteryNumber bonusBall;

    public BonusBall(int number) {
        this.bonusBall = new LotteryNumber(number);
    }

    public boolean match(LotteryNumbers lottery) {
        return lottery.contains(bonusBall);
    }
}
