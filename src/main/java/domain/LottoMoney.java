package domain;

public class LottoMoney {

    private static final int ONE_LOTTO_PRICE = 1000;
    private final int money;

    public LottoMoney(int money) {
        if (validate(money)) {
            this.money = money;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfLotto() {
        return money / ONE_LOTTO_PRICE;
    }

    private boolean validate(int money) {
        if (money < ONE_LOTTO_PRICE) {
            return false;
        }
        return true;
    }
}
