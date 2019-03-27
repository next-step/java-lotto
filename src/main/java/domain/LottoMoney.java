package domain;

public class LottoMoney {

    private static final int ONE_LOTTO_PRICE = 1_000;
    private final int money;

    public LottoMoney(int money) {
        if (money < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getNumberOfLotto() {
        return money / ONE_LOTTO_PRICE;
    }

}
