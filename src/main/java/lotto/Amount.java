package lotto;

public class Amount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Amount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("Amount must multiple of %s", LOTTO_PRICE));
        }
        this.amount = amount;
    }

    public int possibleGame() {
        return amount / LOTTO_PRICE;
    }

    public float earnRate(long totalAward) {
        return (float)totalAward / amount;
    }
}
