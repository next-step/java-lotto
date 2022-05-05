package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wallet {
    private final Money money;
    public final List<Lottery> lotteries;

    public Wallet(Money money) {
        this.money = money;
        this.lotteries = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "money=" + money +
                ", lotteries=" + lotteries +
                '}';
    }

    public boolean moneyEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(money, wallet.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lotteries);
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
