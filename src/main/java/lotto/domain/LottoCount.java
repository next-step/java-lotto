package lotto.domain;

public class LottoCount {

    private final int money;

    public LottoCount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / 1000;
    }
}
