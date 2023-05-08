package lotto.utils;

public class LottoCountCalculator {

    private static final int LOTTO_PRICE = 1000;

    public static int calculateQuantity(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("Invalid amount. The amount must be divisible by %d.", LOTTO_PRICE));
        }
        return amount / LOTTO_PRICE;
    }
}
