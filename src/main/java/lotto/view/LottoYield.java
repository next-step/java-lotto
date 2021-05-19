package lotto.view;

import lotto.domain.PositiveInteger;

public class LottoYield {
    private PositiveInteger reward;
    private PositiveInteger totalPrice;

    public LottoYield(PositiveInteger reward, PositiveInteger totalPrice) {
        this.reward = reward;
        this.totalPrice = totalPrice;
    }

    public double calc() {
        return (double) reward.getValue() / (double) totalPrice.getValue();
    }
}
