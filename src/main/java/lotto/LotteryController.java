package lotto;


import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Money money;
    public final int numberOfLotteries;
    public final List<Lottery> lotteries = new ArrayList<>();

    public LotteryController(int money) {
        this.money = new Money(money);
        this.numberOfLotteries = this.money.price / 1000;
    }

    public void createLotteries() {
        for (int i = 0; i < numberOfLotteries; i++) {
            lotteries.add(new Lottery());
        }
    }
}
