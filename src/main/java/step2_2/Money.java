package step2_2;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    public static Money fromLottoCount(int lottoCount) {
        return new Money(lottoCount * LOTTO_PRICE);
    }

    public Money(int money) {
        checkPositive(money);
        this.money = money;
    }

    private void checkPositive(int money) {
        if (money < 0) {
            throw new InvalidMoneyInputException();
        }
    }

    public int won() {
        return money;
    }

    public boolean canPurchase() {
        return money >= LOTTO_PRICE;
    }

    public void purchaseLotto() {
        money -= LOTTO_PRICE;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
