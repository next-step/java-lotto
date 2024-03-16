package lotto.controller;

import lotto.dto.OrderRequest;
import lotto.dto.OrderResponse;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int money = inputView.askMoney();
        OrderRequest request = new OrderRequest(money);
        OrderResponse response = LottoMachine.purchase(request);

        resultView.printOrderResponse(response);

        List<LottoNumber> winningNumbers = inputView.askWinningNumbers();
        resultView.printResult(response, winningNumbers);
    }
}
