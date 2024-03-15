package lotto.controller;

import lotto.model.Buyer;
import lotto.model.LottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.askMoney();
        Buyer buyer = new Buyer();
        buyer.purchase(money);
        buyer.confirm();

        List<LottoNumber> winningNumbers = inputView.askWinningNumbers();

        resultView.print(buyer.matches(winningNumbers), money);
    }
}
