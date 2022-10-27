package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.input.ManualLottoInput;
import lotto.input.TicketPriceInput;
import lotto.domain.RewardStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        TicketPriceInput ticketPriceInput = inputView.getTicketPriceInput();
        ManualLottoInput manualLottoInput = inputView.getManualCountInput();
        Lottos lottos = Lottos.of(ticketPriceInput, manualLottoInput);
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.getWinningNumbers();
        RewardStatistics rewardStatistics = lottos.countWinningNumbers(winningLotto);
        resultView.printAllResult(rewardStatistics, rewardStatistics.getProfitRatio(lottos));
    }
}
