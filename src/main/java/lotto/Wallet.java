package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Const.LOTTERY_PRICE;

public class Wallet {
    private final Money money;
    public final List<Lottery> lotteries;

    public Wallet(Money money) {
        this.money = money;
        this.lotteries = new ArrayList<>();
    }



    public Wallet(List<Lottery> lotteries) {
        this.money = new Money(0);
        this.lotteries = lotteries;
    }

    public void createLotteries() {
        while (money.enough()) {
            buyLottery();
        }
    }



    public void buyLottery() {
        if (!money.enough()) {
            throw new IllegalCallerException("Not enough money.");
        }
        this.money.pay();
        this.lotteries.add(new Lottery());
    }

    public double getEarnedMoney(int earnedMoney) {
        return this.money.getEarningRate(earnedMoney);
    }
}
