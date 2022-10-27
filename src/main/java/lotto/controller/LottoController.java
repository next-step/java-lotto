package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.input.TicketPriceInput;
import lotto.domain.Reward;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        TicketPriceInput ticketPriceInput = inputView.getTicketPriceInput();
        Lottos lottos = new Lottos(ticketPriceInput.getTicketAmt());
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.getWinningNumbers();
        Reward reward = lottos.countWinningNumbers(winningLotto);
        resultView.printAllResult(reward, reward.getProfitRatio(lottos));
    }
}
