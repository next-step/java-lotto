package domain;

public class Money {

    private static final int MINIMUM_MONEY = 1_000;
    private int money;

    private GameCount gameCount;

    public Money(int money, int manualCount) {
        isValidMoney(money);
        this.money = money;
        this.gameCount = new GameCount(getTotalCount(), manualCount);
    }

    public int getMoney() {
        return money;
    }

    public int getTotalCount() {
        return money / MINIMUM_MONEY;
    }

    private static void isValidMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("금액이 잘못 들어왔습니다.");
        }
    }
}
