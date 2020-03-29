package lotto.view;

import lotto.model.Money;

public class InputView {
    private Money money;

    public InputView(Money money) {
        this.money = money;
    }

    public static InputView of(Money money) {
        return new InputView(money);
    }

    public Money getMoney() {
        return money;
    }
}