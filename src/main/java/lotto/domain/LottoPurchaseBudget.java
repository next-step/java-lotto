package lotto.domain;

public class LottoPurchaseBudget {
    private final int purchaseBudget;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchaseBudget(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        purchaseBudget = money;
    }

    public int countOfAvailableLotto() {
        return purchaseBudget / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object src) {
        if (src == null || src.getClass() != this.getClass()) {
            return false;
        }
        
        return super.equals(src) && ((LottoPurchaseBudget)src).purchaseBudget == purchaseBudget;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        int prime = 17;

        return result * prime + purchaseBudget;
    }
}
