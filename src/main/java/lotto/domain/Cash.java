package lotto.domain;

import java.util.List;

public class Cash {

    static final int PRICE = 1000;

    private final int cash;

    public Cash(int cash) {
        this.cash = cash;
    }

    public int count() {
        return cash / PRICE;
    }

    public float winningRate(int sum) {
        return (float) sum / cash;
    }

    public Cash autoBuy(List<Lotto> manualLottos) {
        return new Cash(cash - manualLottos.size() * PRICE);
    }
}
