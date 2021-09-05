package step2.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;

    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public Amount() {
        this(0);
    }

    public double price() {
        return (double) amount * LOTTO_PRICE;
    }

    public Amount add() {
        return new Amount(this.amount + 1);
    }
}
