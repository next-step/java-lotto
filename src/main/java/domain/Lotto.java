package domain;

public class Lotto {
    private final int money;
    private final int LOTTO_PRICE = 1000;

    public Lotto(int money) {
        this.money = money;
    }

    public int boughtLottoCount() {
        return money / LOTTO_PRICE;
    }
}
