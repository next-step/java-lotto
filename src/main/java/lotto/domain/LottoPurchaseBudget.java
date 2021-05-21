package lotto.domain;

public class LottoPurchaseBudget {

    private final int purchaseBudget;

    public LottoPurchaseBudget(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        purchaseBudget = money;
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
