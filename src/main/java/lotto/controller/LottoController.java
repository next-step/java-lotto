package lotto.controller;

import lotto.dto.OrderRequest;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.Prize;
import lotto.model.WinningLotto;
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
        LottoPaper lottoPaper = LottoMachine.purchase(request);

        resultView.printOrderResponse(lottoPaper.toLottoNumberDtos());

        Lotto winningNumberLotto = inputView.askWinningNumbers();
        LottoNumber bonusNumber = inputView.askBonusNumber(winningNumberLotto);
        WinningLotto winningInfo = new WinningLotto(winningNumberLotto, bonusNumber);

        Prize prize = lottoPaper.matches(winningInfo);

        resultView.printResult(prize, lottoPaper.getQuantity());
    }
}
