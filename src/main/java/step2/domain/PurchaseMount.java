package step2.domain;

public class PurchaseMount {
    private static final int LOTTO_PRICE = 1000;
    private int money;

    public PurchaseMount(int money) {
        this.money = money;
    }

    public int mount() {
        return money / LOTTO_PRICE;
    }

    public int money() {
        return money;
    }
}
