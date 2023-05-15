package lotto.domain;

public class LottoPurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private int amount;

    private LottoPurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static LottoPurchaseAmount of(int amount) {
        validateDivisibilityByPrice(amount);
        return new LottoPurchaseAmount(amount);
    }

    private static void validateDivisibilityByPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("Invalid amount. The amount must be divisible by %d.", LOTTO_PRICE));
        }
    }

    public int calculateQuantity() {
        validateDivisibilityByPrice(amount);
        return amount / LOTTO_PRICE;
    }

    public double calculateProfitRate(int totalPrize) {
        return (double) totalPrize / (double) amount;
    }
}
