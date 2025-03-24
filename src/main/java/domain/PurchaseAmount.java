package domain;

public class PurchaseAmount {
    private final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public int countOfLotto() {
        return amount / LOTTO_PRICE;
    }

}
