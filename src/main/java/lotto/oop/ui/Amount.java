package lotto.oop.ui;

public class Amount {
    public static final int PIRCE_ONE_LOTTO = 1000;
    private int amount;

    public Amount(int money) {
        if (money % PIRCE_ONE_LOTTO != 0) {
            throw new ArithmeticException("구입 금액은 1000원 단위입니다.");
        }
        this.amount = money;
    }

    public int substract(Count handCount) {
        return (amount / PIRCE_ONE_LOTTO) - handCount.getLottoCount();
    }
}
