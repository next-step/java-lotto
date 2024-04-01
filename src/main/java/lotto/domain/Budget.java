package lotto.domain;

public class Budget {

    private int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int purchasableQuantity(Price price) {
        return price.divide(budget);
    }
}
