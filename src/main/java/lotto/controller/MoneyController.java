package lotto.controller;

import lotto.domain.Money.ImmutableMoney;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class MoneyController {

    public ImmutableMoney purchaseMoney() {
        LottoOutput.purchaseAmount();

        return LottoInput.money();
    }
}
