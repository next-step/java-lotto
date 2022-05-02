package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Const.LOTTERY_PRICE;

public class Wallet {
    public int money;
    public List<Integer> answerNumbers;
    public int numberOfLotteries;
    public final List<Lottery> lotteries;

    public Wallet(int money) {
        if (money < LOTTERY_PRICE) {
            throw new IllegalArgumentException("Please give more than 1000 won. but: " + money);
        }
        this.money = money;
        this.lotteries = new ArrayList<>();
        this.answerNumbers = new ArrayList<>();
        this.numberOfLotteries = this.money / LOTTERY_PRICE;
    }

    public Wallet(List<Lottery> lotteries, List<Integer> answerNumbers) {
        this.money = 0;
        this.lotteries = lotteries;
        this.answerNumbers = answerNumbers;
    }

    public void createLotteries() {
        while (this.money >= LOTTERY_PRICE) {
            buyLottery();
        }
    }

    public int getNumberOfLotteries() {
        return this.numberOfLotteries;
    }

    public void buyLottery() {
        if (this.money < LOTTERY_PRICE) {
            throw new IllegalCallerException("Not enough money.");
        }
        this.money -= LOTTERY_PRICE;
        this.lotteries.add(new Lottery());
    }
}
