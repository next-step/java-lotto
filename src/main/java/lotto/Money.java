package lotto;

public class Money {

    private static final double ROUND_STANDARD = 100.0;

    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_MONEY = 0;
    private int money;

    public Money(int money) {
        validInputMoney(money);
        this.money = money;
    }

    public int purchase() {
        return money / LOTTO_PRICE;
    }

    public static Money zero() {
        return new Money(MINIMUM_MONEY);
    }

    public void sum(int target) {
        money += target;
    }

    public double calculateReturnRate(int payed) {
        return Math.floor((double) money / payed * ROUND_STANDARD) / ROUND_STANDARD;
    }

    private static void validInputMoney(int money) {
        if (money % LOTTO_PRICE != MINIMUM_MONEY) {
            throw new IllegalArgumentException(
                String.format("입력값은 %d의 배수여야 합니다.", LOTTO_PRICE));
        }
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("입력값은 양수여야 합니다.");
        }
    }
}
