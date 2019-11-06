package lotto;

public class LottoPrice {
    private static final int PRICE = 1000;

    private int budget;
    private int change;

    public LottoPrice(int budget) {
        this.budget = budget;
        this.change = budget;
        validate();
    }

    private void validate() {
        if (budget < PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEnoughBudget() {
        if (change - PRICE >= 0) {
            change -= PRICE;
            return true;
        }

        return false;
    }

    public int getExpend() {
        return budget - change;
    }
}
