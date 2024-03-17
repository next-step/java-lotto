package lotto.controller;

import lotto.dto.OrderRequest;
import lotto.dto.OrderResponse;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int money = inputView.askMoney();
        OrderRequest request = new OrderRequest(money);
        OrderResponse response = LottoMachine.purchase(request);

        resultView.printOrderResponse(response);

        Lotto winningNumberLotto = inputView.askWinningNumbers();
        resultView.printResult(response, winningNumberLotto);
    }
}
