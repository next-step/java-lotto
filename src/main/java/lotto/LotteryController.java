package lotto;

public class LotteryController {
    public Money money;
    public final int numberOfLotteries;

    public LotteryController(int money) {
        this.money = new Money(money);
        this.numberOfLotteries = this.money.price / 1000;
    }
}
