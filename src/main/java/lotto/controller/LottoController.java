package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Win;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {

    public void play() {

        int money = InputView.getMoney();

        Money userMoney = new Money();
        int amount = userMoney.calculateLottoAmount(money);
        ResultView.printLottoAmount(amount);

        Lotto lotto = new Lotto();
        Win win = new Win();

        List<List> userLottos = new ArrayList<>();

        for (int i = 1; i <= amount; i++) {
            List<Integer> selectedNumbers = lotto.generateLotto();
            ResultView.printLottoNumbers(selectedNumbers);
            userLottos.add(selectedNumbers);
        }

        Set<Integer> winningNumbers = InputView.getWinningNumbers();

        for (List userLott : userLottos) {
            int count = win.countMatchingNumbers(winningNumbers, userLott);
        }
    }
}
