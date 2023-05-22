package lottery.domain;

public class BonusBall {
    private final LotteryNumber value;

    public BonusBall(LotteryNumber value) {
        this.value = value;
    }

    public LotteryNumber value() {
        return value;
    }
}
