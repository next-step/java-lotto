package lotto.domain;

import java.util.List;

public class Cash {

    static final int PRICE = 1000;

    private final int cash;

    public Cash(int cash) {
        if (cash < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력하세요.");
        }
        this.cash = cash;
    }

    public int count() {
        return cash / PRICE;
    }

    public float winningRate(int sum) {
        return (float) sum / cash;
    }

    public Cash autoBuyCash(List<Lotto> manualLottos) {
        int autoCash = cash - manualLottos.size() * PRICE;
        if (autoCash == 0) {
            return null;
        }
        return new Cash(autoCash);
    }
}
