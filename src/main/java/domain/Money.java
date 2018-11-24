package domain;

public class Money {
    static final int PRICE = 1_000;

    private int money;
    private int manualMoney;

    public Money(int money, int manualMoney) {
        this.money = money;
        this.manualMoney = manualMoney;
    }

    public static double profitRatio(int putMoney, int totalProfitMoney) {
        double number = (double)totalProfitMoney / (double)putMoney;
        return Math.round(number*100)/100.0;
    }

    public static Integer sum(Rank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }

    public int turnOfLotto() {
        return (this.money-this.manualMoney)/PRICE;
    }

    public int turnOfManualLotto() {
        return (this.manualMoney)/PRICE;
    }

    public static Money amountOfPurchase(int money, int manual) {
        return new Money(money, manual*PRICE);
    }

    public int getMoney() {
        return money;
    }
}
