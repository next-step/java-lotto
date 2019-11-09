package lotto;

public class Wallet {
    static final int PRICE = 1000;

    private int budget;
    private int change;

    public Wallet(int budget) {
        this.budget = budget;
        this.change = budget;
        validate();
    }

    public boolean isBuyable(int count) {
        return change > count * PRICE;
    }

    public boolean isEnoughBudget() {
        if (change - PRICE >= 0) {
            payMoney();
            return true;
        }

        return false;
    }

    public void payMoney() {
        change -= PRICE;
    }

    public int getExpend() {
        return budget - change;
    }

    private void validate() {
        if (budget < PRICE) {
            throw new IllegalArgumentException();
        }
    }
}
