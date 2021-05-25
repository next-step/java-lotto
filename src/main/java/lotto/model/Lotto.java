package lotto.model;

import static lotto.view.InputView.LOTTO_PRICE;

public class Lotto {

    public Lotto() {
    }

    public int buyCount(int money) {
        return money / LOTTO_PRICE;
    }
}
