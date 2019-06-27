package lotto.model;

public class Money {

    private final int PAID;

    public Money(int PAID) {
        this.PAID = PAID;
    }

    public int getPurchaseableQuantity() {
        return this.PAID / Lotto.PRICE;
    }
}
