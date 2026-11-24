package lotto.domain;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("Purchase amount must be at least " + LOTTO_PRICE + ".");
        }
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getSpentAmount() {
        return getLottoCount() * LOTTO_PRICE;
    }
}
