package lotto.view;

import lotto.domain.PositiveNumber;

public class LottoYield {
    private PositiveNumber reward;
    private PositiveNumber totalPrice;

    public LottoYield(PositiveNumber reward, PositiveNumber totalPrice) {
        this.reward = reward;
        this.totalPrice = totalPrice;
    }

    public double calc() {
        return (double) reward.toLong() / (double) totalPrice.toLong();
    }
}
