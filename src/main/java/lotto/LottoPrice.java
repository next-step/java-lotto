package lotto;

public class LottoPrice {
    public static final int PRICE = 1_000;

    public int getAvailableCount(int amount) {
        if (amount < 0) return 0;
        return amount / PRICE;
    }
}
