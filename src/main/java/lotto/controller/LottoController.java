package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void play() {

        int money = InputView.getMoney();
        Money userMoney = new Money();
        int amount = userMoney.calculateLottoAmount(money);
        ResultView.printLottoAmount(amount);

        Lotto lotto = new Lotto();
        for (int i = 1; i <= amount; i++) {
            List<Integer> selectedNumbers = lotto.generateLotto();
            ResultView.printLottoNumbers(selectedNumbers);
        }
    }
}
