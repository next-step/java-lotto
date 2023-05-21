package domain;

public class Money {

    private static final int MINIMUM_MONEY = 1_000;
    private int money;

    public Money(int money) {
        isValidMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / MINIMUM_MONEY;
    }

    private static void isValidMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("금액이 잘못 들어왔습니다.");
        }
    }
}
