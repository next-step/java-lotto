package lotto.domain;

public class Money {
    private static final String EXCEP_INVALID_MONEY = "Money 값으로 적합하지 않습니다.";
    public static final int MIN_MONEY = 0;
    private final int money;

    Money(int money) {
        checkValidMoney(money);
        this.money = money;
    }

    public static void checkValidMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(EXCEP_INVALID_MONEY + " : " + money);
        }
    }

    public int calculateBuyableLottos(int price) {2
        return money / price;
    }

    public double getYield(int totalPrizeMoney) {
        return (double) totalPrizeMoney / (double) money;
    }
}
