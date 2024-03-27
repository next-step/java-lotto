package lotto;

public class Money {

    private static final double ROUND_STANDARD = 100.0;

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private int money;

    public Money(int money) {
        validInputMoney(money);
        this.money = money;
    }

    public int purchase() {
        return money / LOTTO_PRICE;
    }

    public static Money zero() {
        return new Money(ZERO);
    }

    public void sum(int target) {
        money += target;
    }

    public double calculateReturnRate(int payed){
        return Math.floor((double)money / payed * ROUND_STANDARD) / ROUND_STANDARD;
    }

    private static void validInputMoney(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("입력값은 1000의 배수여야 합니다.");
        }
        if (money < ZERO) {
            throw new IllegalArgumentException("입력값은 양수여야 합니다.");
        }
    }
}
