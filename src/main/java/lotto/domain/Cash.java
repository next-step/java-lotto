package lotto.domain;

public class Cash {

    private static final int PRICE = 1000;

    private final int cash;

    public Cash(int cash) {
        this.cash = cash;
    }

    int getCash() {
        return cash;
    }

    public int count() {
        return cash / PRICE;
    }
}
