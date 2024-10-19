package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void play() {

        int money = InputView.getMoney();
        Money userMoney = new Money();
        int amount = userMoney.calculateLottoAmount(money);
        ResultView.printLottoAmount(amount);
    }
}
