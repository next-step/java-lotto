package lotto.ui;

public class BuyInputView {
    private long money;

    protected BuyInputView(long money) {
        validation(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    private void validation(long money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
