package lotto.controller;

import lotto.domain.money.Money;
import lotto.view.money.MoneyInput;
import lotto.view.money.MoneyOutput;

public class MoneyController {

    public Money purchaseMoney() {
        MoneyOutput.purchaseMoney();
        return inputMoney();
    }

    private Money inputMoney() {
        try {
            return new Money(MoneyInput.money());
        } catch (Exception e) {
            MoneyOutput.moneyInputError();
        }
        return inputMoney();
    }
}
