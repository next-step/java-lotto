package lotto.domain;

import static lotto.util.Price.LOTTO_PRICE;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public int lottoCount() {
        return value / LOTTO_PRICE;
    }
}
