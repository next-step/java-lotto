package lotto.model;

public class Money {

    private int PAID;

    public Money(int PAID) {
        this.PAID = PAID;
    }

    public int getPurchaseableQuantity() {
        return this.PAID / Lotto.PRICE;
    }

    public int makePayment(Quantity quantity) {
        return this.PAID -= Lotto.PRICE * quantity.QUANTITY;
    }
}
