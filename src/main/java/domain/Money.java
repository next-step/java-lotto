package domain;

public class Money {

    private int purchasedMoney;

    public Money(int purchasedMoney) {
        this.purchasedMoney = purchasedMoney;
    }

    public static Money from(int purchasedMoney) {
        return new Money(purchasedMoney);
    }

    public int getMoney() {
        return purchasedMoney;
    }

}
