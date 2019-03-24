package lotto.domain;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;
    public final int money;

    public LottoMoney(int money) {
        checkMinimumAmount(money);
        this.money = money;
    }

    public int buy() {
        return this.money / LOTTO_PRICE;
    }

    private void checkMinimumAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }
}
