package lotto.controller;

import lotto.domain.money.ImmutableMoney;
import lotto.view.money.MoneyInput;
import lotto.view.money.MoneyOutput;

public class MoneyController {

    public ImmutableMoney purchaseMoney() {
        MoneyOutput.purchaseMoney();

        return new ImmutableMoney(MoneyInput.money());
    }
}
