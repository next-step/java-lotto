package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.Statistics;
import lotto.domain.WinNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    public void lotto() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Statistics statistics = new Statistics();

        int money = inputView.inputMoney();
        int count = new Purchase().calculate(money);
        resultView.printPurchase(count);

        List<List<Integer>> lottoList = new Lotto().createLottoList(count);
        resultView.printLotto(lottoList);

        int[] winNumbers = new WinNumber().createWinNumbers(inputView.inputWinNumber());

        statistics.setUp();
        resultView.printStatistics(statistics.save(lottoList, winNumbers), statistics.revenue(money));
    }
}
